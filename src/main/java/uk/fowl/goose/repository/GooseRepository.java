package uk.fowl.goose.repository;

import uk.fowl.goose.model.GooseInfo;
import java.util.ArrayList;

public interface GooseRepository {

    public ArrayList<GooseInfo> getGeese();
    public GooseInfo getGoose(Integer id);
    public Integer addGoose(GooseInfo goose);

}
