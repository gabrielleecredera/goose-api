package uk.fowl.goose.model;

public class ErrorResponse {

    private final String message;
    private final String reason;
    private final String comment;

    public ErrorResponse(String message, String reason, String comment) {
        this.message = message;
        this.reason = reason;
        this.comment = comment;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

    public String getComment() {
        return comment;
    }
}
