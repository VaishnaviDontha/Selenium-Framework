package exceptions;

public class WorkbookIOException extends FrameworkException {

    public WorkbookIOException(String message) {
        super(message);
    }

    public WorkbookIOException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
