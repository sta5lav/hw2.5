package lessons24.Collections;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/department", method = RequestMethod.GET)
public class DepartmentControllerMockitoLesson {

    private final DepartmentService departmentService;

    public DepartmentControllerMockitoLesson(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> getAllEmployeesOfDepartment(@PathVariable int id) {
        return departmentService.allEmployeesDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public int amountSalaryOfDepartment(@PathVariable int id) {
        return departmentService.getAllSalaryOfDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Employee findEmployeeMaxSalary(@PathVariable int id) {
        return departmentService.getMaxSalaryOfOtdel(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee findEmployeeMinSalary(@PathVariable int id) {
        return departmentService.getMinSalaryOfOtdel(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> allEmployees() {
        return departmentService.employeePrintDepartment();
    }

}
