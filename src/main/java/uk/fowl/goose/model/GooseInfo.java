package uk.fowl.goose.model;

public class GooseInfo {

    private Long id;
    private String name;
    private Integer aggression;

    public GooseInfo() {
    }

    public GooseInfo(Long id, String name, Integer aggression) {
        this.id = id;
        this.name = name;
        this.aggression = aggression;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
