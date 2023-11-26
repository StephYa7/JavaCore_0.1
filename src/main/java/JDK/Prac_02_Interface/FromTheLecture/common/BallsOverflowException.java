package JDK.Prac_02_Interface.FromTheLecture.common;

public class BallsOverflowException extends RuntimeException {
    public BallsOverflowException() {
        super("Balls overflow, 15 allowed!");
    }
}