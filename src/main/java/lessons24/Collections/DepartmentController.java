package lessons24.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.getMaxSalaryOfOtdel(department);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.getMinSalaryOfOtdel(department);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeeDepartment(@RequestParam("departmentId") int department) {
        return departmentService.allEmployeesDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployees () {
        return departmentService.employeePrintDepartment();
    }


}
