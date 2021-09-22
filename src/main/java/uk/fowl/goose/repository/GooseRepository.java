package uk.fowl.goose.repository;

import org.springframework.stereotype.Component;
import uk.fowl.goose.GooseInfo;

import java.util.ArrayList;

public interface GooseRepository {

    public ArrayList<GooseInfo> getGeese();
    public GooseInfo getGoose(Integer id);
    public Integer addGoose(GooseInfo goose);

}
