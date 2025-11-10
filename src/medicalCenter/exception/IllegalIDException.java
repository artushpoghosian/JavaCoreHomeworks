package medicalCenter.exception;

public class IllegalIDException extends Exception {
    public IllegalIDException() {
    }

    public IllegalIDException(String message) {
        super(message);
    }

    public IllegalIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalIDException(Throwable cause) {
        super(cause);
    }

    public IllegalIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
