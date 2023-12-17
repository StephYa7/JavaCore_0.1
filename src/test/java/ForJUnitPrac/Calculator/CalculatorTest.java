package ForJUnitPrac.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));

        assertThat(Calculator.calculatingDiscount(100,50)).isEqualTo(50);

//        assertThat(Sqr.mySqrt(9)).isEqualTo(3);
//        Assertions.assertThatThrownBy(() -> Sqr.mySqrt(-5)).isInstanceOf(IllegalArgumentException.class);
//        assert 2 == Sqr.mySqrt(4);
//        Assertions.assertThatThrownBy(() -> Sqr.zeroDev(0)).isInstanceOf(ArithmeticException.class);
//        Assertions.assertThatThrownBy(() -> Sqr.zeroDev(0)).isInstanceOf(Exception.class);

        assertThat(Calculator.calculatingDiscount(99,10)).isEqualTo(89.1);
        assertThatThrownBy(()->Calculator.calculatingDiscount(101,122))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 10))
                .isInstanceOf(ArithmeticException.class);
    }
}