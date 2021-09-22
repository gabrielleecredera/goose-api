package uk.fowl.goose.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.fowl.goose.exceptions.GooseTooAggressiveException;
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

    public Long add(GooseInfo goose) throws GooseTooAggressiveException {

        // Business rule - no super aggressive geese.
        Integer aggression = goose.getAggression();
        if (aggression > 9000) {
            throw new GooseTooAggressiveException(
                    String.format("Against business H&S policy, aggression %d is over 9000", aggression));
        }

        return this.geese.add(goose);
    }
}
