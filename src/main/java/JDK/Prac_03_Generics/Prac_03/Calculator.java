package JDK.Prac_03_Generics.Prac_03;

public class Calculator {

    public static <T extends Number> double sum(T... numbers) {
        if (numbers.length == 1) {
            return (double) numbers[0];
        }
        double result = 0;
        for (T number : numbers) {
            result += number.doubleValue();
        }
        return result;
    }


    public static <T extends Number> double multiply(T... numbers) {
        if (numbers.length == 1) {
            return (double) numbers[0];
        }
        double result = 1;
        for (T number : numbers) {
            result *= number.doubleValue();
        }
        return result;
    }


    public static <T extends Number, V extends Number> double divide(T firstNumber, V secondNumber) {
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtract(T firstNumber, V secondNumber) {
        return firstNumber.doubleValue() - secondNumber.doubleValue();
    }


    public static void main(String[] args) {
        System.out.println(Calculator.sum(1, 2, 3, 4, 33.3, 12.4f, 43232134444L));
        System.out.println(Calculator.multiply(1, 2, 3, 4, 33.3, 12.4f, 43));
        System.out.println(Calculator.divide(1.1245342f, 33L));
        System.out.println(Calculator.subtract(1.1245342f, 33L));
    }
}