package lessons24.Collections;

import lessons24.Collections.exceptions.EmployeeAlreadyAddedException;
import lessons24.Collections.exceptions.EmployeeNotFoundException;
import lessons24.Collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService {
    private final int SIZE = 7;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String firstName, String lastName) {
        return firstName + "|" + lastName;
    }

    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
            Employee employee = new Employee(firstName, lastName, salary, department);
            String key = getKey(firstName, lastName);
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже имеется в коллекции!");
            }
            if (employees.size() < SIZE) {
                employees.put(key, employee);
                return employee;
            }
            throw new EmployeeStorageIsFullException("Коллекция заполнена, места нет!");
        }

    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
        }
        return employees.remove(key);
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
        } else return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}
