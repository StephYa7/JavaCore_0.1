package Test.Area;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle implements AreaCalculate {
    private double sideA;
    private double sideB;
    private double sideC;

    @Override
    public double areaCalculation() {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) *
                (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
}