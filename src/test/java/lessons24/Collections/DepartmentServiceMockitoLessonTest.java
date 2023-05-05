package lessons24.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceMockitoLessonTest {

    @InjectMocks
    DepartmentService departmentService;

    @Mock
    EmployeeService employeeService;


    @BeforeEach
    void setUp() {
        departmentService = new DepartmentService(employeeService);
    }

    @BeforeEach
    void addEmployeesBeforeEach() {
        Mockito.when(employeeService.getAll()).thenReturn(
                List.of(
                        new Employee("Ivan", "Ivanov", 1000, 1),
                        new Employee("Petr", "Ivanov", 3000, 1),
                        new Employee("Sergey", "Ivanov", 2000, 2),
                        new Employee("Sava", "Ivanov", 4000, 2),
                        new Employee("Semen", "Ivanov", 3000, 3),
                        new Employee("Sasha", "Ivanov", 2000, 3)
                ));
    }

    static Stream<Arguments> employeesMaxSalaryList() {
        return Stream.of(
                Arguments.of(1, new Employee("Petr", "Ivanov", 3000, 1)),
                Arguments.of(2, new Employee("Sava", "Ivanov", 4000, 2)),
                Arguments.of(3, new Employee("Semen", "Ivanov", 3000, 3))
        );
    }

    static Stream<Arguments> employeesMinSalaryList() {
        return Stream.of(
                Arguments.of(1, new Employee("Ivan", "Ivanov", 1000, 1)),
                Arguments.of(2, new Employee("Sergey", "Ivanov", 2000, 2)),
                Arguments.of(3, new Employee("Sasha", "Ivanov", 2000, 3))
        );
    }

    static Stream<Arguments> employeesTotalSalaryListOfDepartment() {
        return Stream.of(
                Arguments.of(1, 4000),
                Arguments.of(2, 6000),
                Arguments.of(3, 5000)
        );
    }

    static Stream<Arguments> employeesListOfDepartment() {
        return Stream.of(
                Arguments.of(1,
                        List.of(
                                new Employee("Ivan", "Ivanov", 1000, 1),
                                new Employee("Petr", "Ivanov", 3000, 1))
                ),
                Arguments.of(2,
                        List.of(
                        new Employee("Sergey", "Ivanov", 2000, 2),
                        new Employee("Sava", "Ivanov", 4000, 2)),
                Arguments.of(3,
                        List.of(
                        new Employee("Semen", "Ivanov", 3000, 3),
                        new Employee("Sasha", "Ivanov", 2000, 3))
        )));
    }


    @Test
    void amountSalaryOfDepartmentTest() {
        assertEquals(4000, departmentService.getAllSalaryOfDepartment(1));
        assertEquals(6000, departmentService.getAllSalaryOfDepartment(2));
        assertEquals(5000, departmentService.getAllSalaryOfDepartment(3));

    }

    @MethodSource("employeesMaxSalaryList")
    @ParameterizedTest
    void findEmployeeMaxSalaryTest(int department, Employee employee) {
        assertThat(departmentService.getMaxSalaryOfOtdel(department)).isEqualTo(employee);
        assertEquals(departmentService.getMaxSalaryOfOtdel(department), employee);

    }

    @MethodSource("employeesMinSalaryList")
    @ParameterizedTest
    void findEmployeeMinSalaryTest(int department, Employee employee) {
        assertThat(departmentService.getMinSalaryOfOtdel(department)).isEqualTo(employee);
        assertEquals(departmentService.getMinSalaryOfOtdel(department), employee);

    }

    @MethodSource("employeesTotalSalaryListOfDepartment")
    @ParameterizedTest
    void findEmployeeMinSalaryTest(int department, int totalSalary) {
        assertThat(departmentService.getAllSalaryOfDepartment(department)).isEqualTo(totalSalary);
        assertEquals(departmentService.getAllSalaryOfDepartment(department), totalSalary);

    }

    @MethodSource("employeesListOfDepartment")
    @ParameterizedTest
    void allEmployeesOfDepartment(int department, List<Employee> employee) {
        assertEquals(employee, departmentService.allEmployeesDepartment(department));
    }

}