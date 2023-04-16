package lessons24.Collections;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String salary;
    private final String departament;

    public Employee(String firstName, String lastName, String salary, String departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departament = departament;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartament() {
        return departament;
    }

    @Override
    public String toString() {
        return "{\"firstName\": " + "\"" + firstName + "\"" +
                ", \"lastName\": " + "\"" + lastName + "\"" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}