package uk.fowl.goose;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

public interface GooseRepository {

    public ArrayList<GooseInfo> getGeese();
    public GooseInfo getGoose(Integer id);
    public Integer addGoose(GooseInfo goose);

}
