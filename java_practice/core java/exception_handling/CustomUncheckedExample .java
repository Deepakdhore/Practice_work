package exception_handling;
class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

class CustomUncheckedExample {
    public static void main(String[] args) {
        throw new InvalidInputException("This input is not valid.");
    }
}
