package com.employee.controller;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.model.DepartmentRequest;
import com.employee.service.EmployeeInfoBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeInfoBusinessService employeeInfoBusinessService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody DepartmentRequest request) {
        employeeInfoBusinessService.createDepartmentWithEmployees(request.getDepartmentName(),request.getEmployeeNames());
        return ResponseEntity.accepted().body("Request accepted");
    }

    /*@GetMapping("/findAll")
    public ArrayList<Employee> getAllEmployees() {
        return employeeInfoBusinessService.findAllEmployee();
    }*/

    @GetMapping("/department/{name}")
    public ResponseEntity<List<Employee>> getAllEmployeesUnderDepartment(@PathVariable String name) {
        List<Employee> employees = employeeInfoBusinessService.findAllByDepartment(name);
        if (null == employees || employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.ok(employees);

    }

    @GetMapping("/empname/{prefix}")
    public ResponseEntity<List<Employee>> getAllEmployeeStartWith(@PathVariable String prefix) {
        List<Employee> employees =employeeInfoBusinessService.findAllEmployeeStartWith(prefix);
        if (null == employees || employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.ok(employees);

    }

    @GetMapping("/sort/deptAndEmpId")
    public ResponseEntity<List<Employee>> getAllEmployeesSortByDeptNameAndEmpId() {
        List<Employee> employees =  employeeInfoBusinessService.findAllEmployeesSortByDeptNameAndEmpId();
        if (null == employees || employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.ok(employees);
    }

    @GetMapping("/{department_name}/sort/empName")
    public ResponseEntity<List<Employee>> getAllEmployeesByDeptNameSortByEmpId(@PathVariable String department_name) {
        List<Employee> employees= employeeInfoBusinessService.findEmployeesByDeptNameSortByEmpId(department_name);
        if (null == employees || employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.ok(employees);
    }


    @GetMapping("/department/empid/{employee_number}")
    public ResponseEntity<Department> getDeptOfEmployee(@PathVariable Integer employee_number) {
        Department department=  employeeInfoBusinessService.findDeptOfEmployee(employee_number);
        if (null == department ) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.ok(department);
    }

}
