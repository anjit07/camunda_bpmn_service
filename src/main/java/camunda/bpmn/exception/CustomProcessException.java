package camunda.bpmn.exception;

public class CustomProcessException extends RuntimeException {

    private final String errorCode;

    public CustomProcessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}