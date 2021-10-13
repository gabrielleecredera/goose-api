package uk.fowl.goose.model;

public class GooseCreatedResponse {

    private final Long id;
    private final String message;

    public GooseCreatedResponse(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
