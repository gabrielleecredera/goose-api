package uk.fowl.goose.model;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id = null;
    private String name = null;
    private Integer aggression = null;

}
