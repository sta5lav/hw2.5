package lessons24.Collections;

import lessons24.Collections.exceptions.EmployeeAlreadyAddedException;
import lessons24.Collections.exceptions.EmployeeNotFoundException;
import lessons24.Collections.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void addEmployeeTest() {
        Map<String, Employee> employeeMap = new HashMap<>();
        String key = "Ivan|Ivanov";
        Employee emp = new Employee("Ivan", "Ivanov", 1000, 1);
        employeeMap.put(key, emp);
        assertEquals(emp,employeeService.addEmployee("Ivan", "Ivanov", 1000, 1));
        assertEquals(employeeMap.get(key), employeeService.findEmployee("Ivan", "Ivanov"));
        assertNotSame(emp, employeeService.findEmployee("Ivan", "Ivanov"));

    }

    @Test
    void employeeNotNull() {
        employeeService.addEmployee("Petr", "Petrov", 2000, 1);
        assertNotNull(employeeService.getAll());
    }

    @Test
    void removeEmployeeThrow() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee("Ivan","Ivanov"));
    }

    @Test
    void findEmployeeThrow() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Ivan","Ivanov"));
    }

    @Test
    void addEmployeeThrow() {
        employeeService.addEmployee("Ivan", "Ivanov", 1000, 1);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("Ivan", "Ivanov", 1000, 1));
    }

    @Test
    void fullStorageMapThrow() {
        employeeService.addEmployee("Ivan", "Ivanov", 1000, 1);
        employeeService.addEmployee("Petr", "Ivanov", 1000, 1);
        employeeService.addEmployee("Tisha", "Ivanov", 1000, 1);
        employeeService.addEmployee("Sasha", "Ivanov", 1000, 1);
        employeeService.addEmployee("Sashok", "Ivanov", 1000, 1);
        employeeService.addEmployee("Sava", "Ivanov", 1000, 1);
        employeeService.addEmployee("Saveliy", "Ivanov", 1000, 1);
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee("Sergey", "Ivanov", 1000, 1));
    }

    @Test
    void testAllEmployeeList() {
        Employee emp = new Employee("Petr", "Petrov", 2000, 1);
        List<Employee> list = new ArrayList<>();
        list.add(0, emp);
        employeeService.addEmployee("Petr", "Petrov", 2000, 1);
        assertEquals(list, employeeService.getAll());
    }

    @Test
    void removeEmployeeTestNull() {
        employeeService.addEmployee("Petr", "Petrov", 2000, 1);
        employeeService.removeEmployee("Petr", "Petrov");
        ArrayList<String> empty = new ArrayList<>();
        assertEquals(empty, employeeService.getAll());
    }

    @Test
    void findEmployee() {
        employeeService.addEmployee("Petr", "Petrov", 2000, 1);
        Employee emp = new Employee("Petr", "Petrov", 2000, 1);
        assertEquals(emp, employeeService.findEmployee("Petr", "Petrov"));
    }

}