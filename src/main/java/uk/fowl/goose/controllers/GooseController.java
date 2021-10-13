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
        return geese.list();
    }

    @PostMapping("/goose")
    public ResponseEntity goose(@RequestBody GooseInfo goose) {
        try {
            Long gooseId = geese.add(goose);
            HashMap<String,Object> responseData = new HashMap<>();
            responseData.put("message", "Goose Added");
            responseData.put("id", gooseId);
            return new ResponseEntity(responseData, HttpStatus.OK);

        } catch(GooseTooAggressiveException e) {
            HashMap<String,Object> responseData = new HashMap<>();
            responseData.put("message", "Policy Violation");
            responseData.put("reason", e.getMessage());
            responseData.put("comment", "What 9000? There's no way that can be right!!!");
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        }
    }

}

