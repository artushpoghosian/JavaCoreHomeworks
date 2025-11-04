package employee.exception;

public class PositionLevelNotFoundException extends RuntimeException {
    public PositionLevelNotFoundException() {
    }

    public PositionLevelNotFoundException(String message) {
        super(message);
    }

    public PositionLevelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PositionLevelNotFoundException(Throwable cause) {
        super(cause);
    }

    public PositionLevelNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
