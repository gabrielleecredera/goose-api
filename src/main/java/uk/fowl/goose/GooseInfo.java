package uk.fowl.goose;

public class GooseInfo {

    public GooseInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAggression() {
        return aggression;
    }

    public void setAggression(Integer aggression) {
        this.aggression = aggression;
    }

    private String name = null;
    private Integer aggression = null;

}
