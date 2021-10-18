package uk.fowl.goose.repositories.impl;

import org.springframework.stereotype.Component;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repositories.GooseRepository;

import java.util.ArrayList;

@Component
public class InMemoryGooseRepository implements GooseRepository {

    private final ArrayList<GooseInfo> gooseList;

    public InMemoryGooseRepository() {
        this.gooseList = new ArrayList<GooseInfo>();
    }

    public ArrayList<GooseInfo> findAll() {
        return gooseList;
    }

    public GooseInfo get(Integer id) {
        return gooseList.get(id);
    }

    public Long add(GooseInfo goose) {
        long id = (long) gooseList.size();
        goose.setId(id);
        gooseList.add(goose);
        return id;
    }

    public ArrayList<GooseInfo> search(String name) {
        ArrayList<GooseInfo> finalList = (ArrayList<GooseInfo>) gooseList.clone();
        finalList.removeIf(gooseInfo -> !(gooseInfo.getName().contains(name)));
        return finalList;
    }
}
