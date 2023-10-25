package Prac_3;

public class Supervisor extends Employee {

    public Supervisor(String firstName, String middleName, String lastName, String phoneNumber, int age, int salary) {
        super(firstName, middleName, lastName, phoneNumber, age, salary);
    }

    public static void upSalary(Employee[] list, int age, int salaryRise) {
        for (Employee employee : list) {
            if (!(employee instanceof Supervisor)) {
                if (employee.getAge() >= age) {
                    employee.setSalary(employee.getSalary() + salaryRise);
                }
            }
        }
    }
}