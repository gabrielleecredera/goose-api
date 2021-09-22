package uk.fowl.goose.repository.impl;

import org.springframework.stereotype.Component;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repository.GooseRepository;

import java.util.ArrayList;

@Component
public class InMemoryGooseRepository implements GooseRepository {

    private ArrayList<GooseInfo> gooseList;

    public InMemoryGooseRepository() {
        this.gooseList = new ArrayList<GooseInfo>();
    }

    public ArrayList<GooseInfo> findAll() {
        return this.gooseList;
    }

    public GooseInfo get(Integer id) {
        return this.gooseList.get(id);
    }

    public Long add(GooseInfo goose) {
        Long id = Long.valueOf(gooseList.size());
        goose.setId(id);
        this.gooseList.add(goose);
        return id;
    }

}
