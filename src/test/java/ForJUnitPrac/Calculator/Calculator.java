package ForJUnitPrac.Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double num) {

        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount <= 0 || discountAmount > 100) throw new ArithmeticException();
        double result = purchaseAmount - purchaseAmount * ((double) discountAmount) / 100;
        return result;
    }

    public static double exponentiate(double number, int power) {
        if (number == 1 || power == 0) return 1;
        if (power == 1) return number;
        double result = number;
        for (int i = 1; i < power; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
    }
}