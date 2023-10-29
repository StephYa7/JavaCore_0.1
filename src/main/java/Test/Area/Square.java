package Test.Area;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square implements AreaCalculate {

    private double side;

    @Override
    public double areaCalculation() {
        return side*side;
    }
}