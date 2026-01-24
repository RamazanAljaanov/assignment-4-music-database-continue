package exception;

// По заданию: должен наследоваться от InvalidInputException
public class DuplicateResourceException extends InvalidInputException {
    public DuplicateResourceException(String message) {
        super(message);
    }
}