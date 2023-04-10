package lessons24.Collections;

import lessons24.Collections.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ричард", "Гир"),
            new Employee("Том", "Круз"),
            new Employee("Пол", "Макартни"),
            new Employee("Леонардо", "Дикаприо")));


    public String addEmployee(Employee employee) {
        try {
            checkAddEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return String.valueOf(employees.get(employees.indexOf(employee)));

    }

    public String removeEmployee(Employee employee) {
        try {
            checkRemoveEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return String.valueOf(employees.get(employees.indexOf(employee)));

    }

    public String findEmployee(Employee employee) {
        try {
            checkFindEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return String.valueOf(employees.get(employees.indexOf(employee)));
    }

    public String getEmployee() {
        return employees.toString();
    }

    private void checkFindEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден!");
        } else employees.contains(employee);
    }

    private void checkAddEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник уже имеется в коллекции!");
        } else employees.add(employee);
    }

    private void checkRemoveEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник отсутствует в коллекции!");
        } else employees.remove(employee);
    }
}
