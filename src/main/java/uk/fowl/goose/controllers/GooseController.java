package uk.fowl.goose.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.services.GooseService;

import java.util.ArrayList;

@RestController
public class GooseController {

    @Autowired
    private GooseService geese;

    @GetMapping("/geese")
    public @ResponseBody ArrayList<GooseInfo> index() {
        return this.geese.list();
    }

    @PostMapping("/goose")
    public String goose(@RequestBody GooseInfo goose) {
        Long id = this.geese.add(goose);
        return String.format("Goose recorded id %d", id);
    }

}

