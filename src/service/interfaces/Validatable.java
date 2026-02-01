package service.interfaces;
import exception.InvalidInputException;

public interface Validatable<T> {
    void validate(T entity) throws InvalidInputException;
    static void logStart(String name) { System.out.println("[SOLID] Validating: " + name); }
    default void logSuccess() { System.out.println("[SOLID] Validation success!"); }
}