package Test.Area;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(4);
        Triangle triangle = new Triangle(6, 7, 12);

        List<AreaCalculate> areas = new ArrayList<>();
        areas.add(square);
        areas.add(triangle);

        for (AreaCalculate area : areas) {
            System.out.println(area.areaCalculation());
        }
    }
}