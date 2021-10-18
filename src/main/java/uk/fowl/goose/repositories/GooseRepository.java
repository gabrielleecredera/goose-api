package uk.fowl.goose.repositories;

import uk.fowl.goose.model.GooseInfo;
import java.util.ArrayList;

public interface GooseRepository {

    public ArrayList<GooseInfo> findAll();
    public GooseInfo get(Integer id);
    public Long add(GooseInfo goose);
    public ArrayList<GooseInfo> search(String name);

}
