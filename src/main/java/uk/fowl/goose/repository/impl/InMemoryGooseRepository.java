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

    public ArrayList<GooseInfo> getGeese() {
        return this.gooseList;
    }

    public GooseInfo getGoose(Integer id) {
        return this.gooseList.get(id);
    }

    public Integer addGoose(GooseInfo goose) {
        this.gooseList.add(goose);
        return gooseList.size() - 1;
    }

}
