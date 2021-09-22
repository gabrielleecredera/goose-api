package uk.fowl.goose.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repository.GooseRepository;

import java.util.ArrayList;

@RestController
public class GooseController {

    private final GooseRepository geese;

    @Autowired
    public GooseController(GooseRepository repo) {
        this.geese = repo;
    }

    @GetMapping("/geese")
    public @ResponseBody ArrayList<GooseInfo> index() {
        return this.geese.getGeese();
    }

    @PostMapping("/goose")
    public String goose(@RequestBody GooseInfo goose) {
        Integer id = this.geese.addGoose(goose);
        return String.format("Goose recorded id %d", id);
    }

}

