package Prac_3;

import lombok.*;

import java.util.Arrays;
@Data
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private int salary;

    public void printInfo() {
        System.out.printf("%s", this);
    }



    public static void avgAgeAndSalary(Employee[] list) {
        System.out.println(Arrays.stream(list).mapToInt(e -> e.getAge()).sum() / list.length);
        System.out.println(Arrays.stream(list).mapToInt(e -> e.getSalary()).sum() / list.length);
    }

    public static int compare(int yearA, int monthA, int dayA, int yearB, int monthB, int dayB) {
        return Integer.compare(yearA * 365 + monthA * 30 + dayA, yearB * 365 + monthB * 30 + dayB);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Vas1", "Das", "Babas", "9039217766", 11, 44222);
        Employee employee2 = new Employee("Vas2", "Das", "Babas", "9039217766", 21, 44222);
        Employee employee3 = new Employee("Vas3", "Das", "Babas", "9039217766", 31, 44222);
        Employee employee4 = new Supervisor("S1", "Das", "Babas", "9039217766", 41, 44222);
        Employee employee5 = new Supervisor("S2", "Das", "Babas", "9039217766", 33, 44222);
        Employee[] list = new Employee[]{employee1, employee2, employee3, employee4, employee5};
        System.out.println(Arrays.toString(list));
        Supervisor.upSalary(list, 22, 999);
        System.out.println(Arrays.toString(list));
        avgAgeAndSalary(list);

        System.out.println(compare(1987, 12, 1, 1987, 1, 1));
    }


}