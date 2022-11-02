public class UserExistException extends RuntimeException {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public UserExistException(String message) {
        super(ANSI_RED + message + ANSI_RESET);
    }
}