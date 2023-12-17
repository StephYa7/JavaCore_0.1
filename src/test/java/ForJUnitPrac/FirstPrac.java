package ForJUnitPrac._01_Prac;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FirstPrac {
    public static void main(String[] args) {
        assertThat(Sqr.mySqrt(9)).isEqualTo(3);
        assertThatThrownBy(() -> Sqr.mySqrt(-5)).isInstanceOf(IllegalArgumentException.class);
        assert 2 == Sqr.mySqrt(4);
        assertThatThrownBy(() -> Sqr.zeroDev(0)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Sqr.zeroDev(0)).isInstanceOf(Exception.class);


        assertConditionA();                                                            // Задание №1
        assertConditionB();                                                           // Задание №2
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));               // Задание №3
        happyNY();                                                                  // Задание №4
        checkingShoppingCart();                                                    // Задание №5
//        int x = -2;
//        assert x > 0 : "x is negative";
        expectedValue();                                                        // Задание №6

        String[] colors = {"aqua", "yellow", "blue", "orange", "green", "violet", "gold"};
        testingJavaCollectionsAssertJ(colors);                               // Задание №7
        checkingHero();                                                     // Задание №8


    }


    public static void assertConditionA() { // Задание №1
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }

    public static void assertConditionB() { // Задание №2
        int x = -1;
        assert x <= 0;
    }

    public static int sum(int a, int b) { // Задание №3
        if (((long) a + (long) b) > Integer.MAX_VALUE) {
            System.out.println("Переполнение переменной!");
        }
        return a + b;
    }

    public static void happyNY() { // Задание №4
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(calendar.getTime());
//        assert currentDateTime.equals("01/01/2024 00:00:00") : "Еще 2023 год :(";
        System.out.println("С новым годом!");
    }

    public static void checkingShoppingCart() { // Задание №5
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
//        products.add("water");
        for (String product : products) {
            if (product.equals("apple")) {
                System.out.println("category: " + productCategories.get(0));
            } else if (product.equals("tomato")) {
                System.out.println("category: " + productCategories.get(1));
            } else if (product.equals("bread")) {
                System.out.println("category: " + productCategories.get(2));
            } else {
                assert false : "Unknown category for the product " + product;
            }
        }
    }

    public static void expectedValue() { // Задание №6
        assertThat(5).isEqualTo(sum(2, 3));
    }

    public static void testingJavaCollectionsAssertJ(String[] colors) { // Задание №7
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }


    public static void checkingHero() { // Задание №8
        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
        assertThat(emmett.getName()).isEqualTo("Emmett");
        assertThat(emmett.getArmorStrength()).isEqualTo(50);
        assertThat(emmett.getWeapon()).isEqualTo("sword");
        assertThat(heroBag)
                .isNotEmpty()
                .hasSize(3)
                .contains("Bow", "Axe", "Gold");
        assert true == emmett.isHuman();


    }

    @Data
    static class Hero {
        private String name;
        private int armorStrength;
        private String weapon;
        private List<String> bag;
        private boolean isHuman;

        public Hero(String name, int armorStrength, String weapon, List<String> bag, boolean isHuman) {
            this.name = name;
            this.armorStrength = armorStrength;
            this.weapon = weapon;
            this.bag = bag;
            this.isHuman = isHuman;
        }
    }
}