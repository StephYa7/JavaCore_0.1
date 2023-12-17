package ForJUnitPrac._01_Prac;


import org.apache.commons.math3.exception.ZeroException;
import org.graphper.util.Asserts;

public class Sqr {
    public static void main(String[] args) {
//        System.out.println(mySqrt(-22));
        System.out.println(2/0);
    }


    public static double mySqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(number);
    }

    public static void zeroDev(int number){

        if (number == 0) {
            throw new ArithmeticException();
        }

    }



}