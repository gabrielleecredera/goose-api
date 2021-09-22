package uk.fowl.goose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class GooseController {

    private GooseRepository geese;

    @Autowired
    public GooseController(GooseRepository repo) {
        this.geese = repo;
    }

    @GetMapping("/")
    public @ResponseBody ArrayList<GooseInfo> index() {
        return this.geese.getGeese();
    }

    @PostMapping("/goose")
    public String goose(@RequestBody GooseInfo goose) {
        Integer id = this.geese.addGoose(goose);
        return String.format("Goose recorded id %d", id);
    }

}

