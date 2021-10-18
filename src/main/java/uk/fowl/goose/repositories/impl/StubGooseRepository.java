package uk.fowl.goose.repositories.impl;

import uk.fowl.goose.exceptions.GooseNotFoundException;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repositories.GooseRepository;

import java.util.ArrayList;

public class StubGooseRepository implements GooseRepository {
    public static final GooseInfo GERALD = new GooseInfo(1L, "Gerald", 1000);

    @Override
    public ArrayList<GooseInfo> findAll() {
        return null;
    }

    @Override
    public GooseInfo get(Integer id) {
        if (id == 1L) {
            return GERALD;
        } else {
            throw new GooseNotFoundException("weeeeee");
        }
    }

    @Override
    public Long add(GooseInfo goose) {
        return 1L;
    }

    @Override
    public ArrayList<GooseInfo> search(String name) {
        return null;
    }

    @Override
    public GooseInfo delete(Integer id) {
        return null;
    }
}
