package JavaCore.Prac_4.Task_01_Logger;

public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException() {
        super();
    }


}