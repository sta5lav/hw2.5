package lessons24.Collections;

import lessons24.Collections.exceptions.EmployeeAlreadyAddedException;
import lessons24.Collections.exceptions.EmployeeNotFoundException;
import lessons24.Collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

        public Employee removeEmployee(String firstName, String lastName){
            Employee employee = new Employee(firstName, lastName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
            } else employees.remove(employee);
            return employee;
        }

        public Employee findEmployee(String firstName, String lastName){
            Employee employee = new Employee(firstName, lastName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
            } else return employee;
        }

        public Collection<Employee> getEmployee () {
            return employees;
        }
    }
