package uk.fowl.goose.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.fowl.goose.exceptions.GooseNotFoundException;
import uk.fowl.goose.exceptions.GooseTooAggressiveException;
import uk.fowl.goose.model.ErrorResponse;
import uk.fowl.goose.model.GooseInfo;
import uk.fowl.goose.repositories.GooseRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class GooseService {

    public GooseService(@Autowired GooseRepository geese) {
        this.geese = geese;
    }

    private final GooseRepository geese;

    public ArrayList<GooseInfo> list() {
        return geese.findAll();
    }

    public Long add(GooseInfo goose) {

        // Business rule - no super aggressive geese.
        Integer aggression = goose.getAggression();
        if (aggression > 9000) {
            throw new GooseTooAggressiveException(
                    String.format("Against business H&S policy, aggression %d is over 9000", aggression));
        }

        return geese.add(goose);
    }

    public GooseInfo delete(int id) {
        GooseInfo result = geese.delete(id);
        if (result != null) {
            return result;
        } else {
            throw new GooseNotFoundException("Goose with id:" + id + " does not exist :(");
        }
    }

    public GooseInfo get(int id) {
        try {
            return geese.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new GooseNotFoundException("Goose with id:" + id + " does not exist :(");
        }
    }

    public ArrayList<GooseInfo> search(String name) {
        return geese.search(name);
    }
}
