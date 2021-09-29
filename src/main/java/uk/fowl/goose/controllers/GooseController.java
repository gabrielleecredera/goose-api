package uk.fowl.goose.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.fowl.goose.exceptions.GooseTooAggressiveException;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.services.GooseService;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class GooseController {

    @Autowired
    private GooseService geese;

    @GetMapping("/geese")
    public @ResponseBody ArrayList<GooseInfo> index() {
        return this.geese.list();
    }

    @PostMapping("/goose")
    public ResponseEntity goose(@RequestBody GooseInfo goose) {
        try {

            Long goose_id = this.geese.add(goose);
            HashMap<String,Object> response_data = new HashMap<>();
            response_data.put("message", "Goose Added");
            response_data.put("id", goose_id);
            return new ResponseEntity(response_data, HttpStatus.OK);

        } catch(GooseTooAggressiveException e) {
            HashMap<String,Object> response_data = new HashMap<>();
            response_data.put("message", "Policy Violation");
            response_data.put("reason", e.getMessage());
            response_data.put("comment", "What 9000? There's no way that can be right!!!");
            return new ResponseEntity(response_data, HttpStatus.BAD_REQUEST);
        }
    }

}

