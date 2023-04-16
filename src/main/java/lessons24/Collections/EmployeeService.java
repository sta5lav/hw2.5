package lessons24.Collections;

import lessons24.Collections.exceptions.EmployeeAlreadyAddedException;
import lessons24.Collections.exceptions.EmployeeNotFoundException;
import lessons24.Collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@Service
public class EmployeeService {
    private final int SIZE = 5;
    private final Collection<Employee> employees = new ArrayList<>();


    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() < SIZE) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже имеется в коллекции!");
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException("Коллекция заполнена, места нет!");
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
        } else employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
        } else return employee;
    }

    public Collection<Employee> getEmployee() {
        return employees;
    }


    static void getMinSalaryOfOtdel(Collection<Employee> employee, String departament) {
        if (departament> 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        int min = Integer.MAX_VALUE;
        String minSalaryOfOtdel = null;
        employee.stream().forEach(employee1 -> employee1.getSalary());
        employee.stream(Comparator.comparingInt(employee -> employee.getSalary());
        }
        for (int i = 0; i < employee.; i++) {
            if (employee[i].getOtdel() == otdel && min > employee[i].getSalary()) {
                min = employee[i].getSalary();
            }
        }
        for (Employee value : employee) {
            if (min == value.getSalary()) {
                minSalaryOfOtdel = value.getName() + " " + value.getMiddleName() + " " + value.getSurname();
            }
        }
        System.out.println("Сотрудник отдела " + otdel + " с минимальной зарплатой: " + minSalaryOfOtdel + " (" + min + ") ");
    }

    static void getMaxSalaryOfOtdel(int departament) {
        if (departament > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        int max = Integer.MIN_VALUE;
        String minSalaryOfOtdel = null;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == departament && max < employee[i].getSalary()) {
                max = employee[i].getSalary();
            }
        }
        for (Employee value : employee) {
            if (max == value.getSalary()) {
                minSalaryOfOtdel = value.getName() + " " + value.getMiddleName() + " " + value.getSurname();
            }
        }
        System.out.println("Сотрудник отдела " + otdel + " с максимальной зарплатой: " + minSalaryOfOtdel + " (" + max + ") ");
    }

    static void getEmployeesListOfOtdel(Employee[] employee, int otdel) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel) {
                System.out.println("id = " + employee[i].getId() + ", сотрудник: " + employee[i].getName() + " " + employee[i].getMiddleName() + " " + employee[i].getSurname() + ", зарплата:" + employee[i].getSalary());
            }
        }
    }
}
