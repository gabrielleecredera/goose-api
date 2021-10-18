package uk.fowl.goose.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.fowl.goose.exceptions.GooseNotFoundException;
import uk.fowl.goose.exceptions.GooseTooAggressiveException;
import uk.fowl.goose.model.ErrorResponse;
import uk.fowl.goose.model.GooseCreatedResponse;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.services.GooseService;

import java.util.ArrayList;
import java.util.HashMap;

@CrossOrigin()
@RestController
public class GooseController {

    private final GooseService geese;

    @Autowired
    public GooseController(GooseService geese) {
        this.geese = geese;
    }

    @GetMapping("/geese")
    public @ResponseBody ArrayList<GooseInfo> index() {
        return geese.list();
    }

    @GetMapping("/goose/{id}")
    public @ResponseBody GooseInfo getGoose(@PathVariable int id) {
        return geese.get(id);
    }

    @CrossOrigin()
    @DeleteMapping("/goose/{id}")
    public @ResponseBody GooseInfo deleteGoose(@PathVariable int id) { return geese.delete(id); }

    @GetMapping("/goose")
    public @ResponseBody ArrayList<GooseInfo> search(@RequestParam(value="name") String name) {
        return geese.search(name);
    }

    @PostMapping("/goose")
    public GooseCreatedResponse goose(@RequestBody GooseInfo goose) {
        Long gooseId = geese.add(goose);
        return new GooseCreatedResponse(gooseId, "Goose added!");
    }

    @ExceptionHandler({ GooseTooAggressiveException.class })
    public ResponseEntity<ErrorResponse> handleGooseTooAggressiveException(GooseTooAggressiveException exception) {
        ErrorResponse errorResponse = new ErrorResponse("Policy violation", exception.getMessage(), "What 9000? There's no way that can be right!!!");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({GooseNotFoundException.class })
    public ResponseEntity<ErrorResponse> handleGooseNotFoundExcpetion(GooseNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse("Policy violation", e.getMessage(), "You're so dumb");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

