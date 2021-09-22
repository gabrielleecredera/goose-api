package uk.fowl.goose.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repository.GooseRepository;

import java.util.ArrayList;

@Service
public class GooseService {

    @Autowired
    private GooseRepository geese;

    public ArrayList<GooseInfo> list() {
        return this.geese.findAll();
    }

    public Long add(GooseInfo goose) {
        return this.geese.add(goose);
    }
}
