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
        long id;
        if (gooseList.size() == 0) {
            id = 0;
        } else {
            id = (long) gooseList.get(gooseList.size() - 1).getId() + 1;
        }
        goose.setId(id);
        gooseList.add(goose);
        return id;
    }

    public ArrayList<GooseInfo> search(String name) {
        ArrayList<GooseInfo> finalList = (ArrayList<GooseInfo>) gooseList.clone();
        finalList.removeIf(gooseInfo -> !(gooseInfo.getName().contains(name)));
        return finalList;
    }

    public GooseInfo delete(Integer id) {
        for (int i = 0; i < gooseList.size(); i++) {
            if (gooseList.get(i).getId() == Long.valueOf(id)) {
                return gooseList.remove(i);
            }
        }
        return null;
    }
}
