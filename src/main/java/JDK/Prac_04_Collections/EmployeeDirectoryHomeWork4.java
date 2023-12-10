package JDK.Prac_04_Collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmployeeDirectoryHomeWork4 {
    List<Employee> employees;

    public List<Employee> searchEmployeesByExperienceInMonths(int requiredExperience) {
        List<Employee> result = employees.stream()
                .filter(e -> e.getExperienceInMonths() == requiredExperience)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> searchPhoneNumberByNameEmployee(String requiredName) {
        List<String> result = employees.stream()
                .filter(a -> a.getName().equals(requiredName))
                .map(a -> a.getPhoneNumber())
                .collect(Collectors.toList());
        return result;
    }

    public Employee searchEmployeesBePersonNumber(int personNumber) {
        Employee result = employees.stream()
                .filter(e -> e.getExperienceInMonths() == personNumber)
                .findFirst()
                .get();
        return result;
    }

    public void addNewEmployee(int personNumber, String phoneNumber, String name, int experienceInMonths) {
        Employee newEmployee = new Employee(personNumber, phoneNumber, name, experienceInMonths);
        if (!employees.contains(newEmployee)) {
            employees.add(newEmployee);
        }
    }

    public void addNewEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }
}

@Data
@AllArgsConstructor
class Employee {
    private int personNumber;
    private String phoneNumber;
    private String name;
    private int experienceInMonths;

}