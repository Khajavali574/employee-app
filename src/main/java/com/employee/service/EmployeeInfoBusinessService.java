package com.employee.service;

import com.employee.entity.Department;
import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeInfoBusinessService {
    Department createDepartmentWithEmployees(String departmentName, List<String> employeeNames);
    //ArrayList<Employee> findAllEmployee();
    List<Employee> findAllByDepartment(String name);
    List<Employee> findAllEmployeeStartWith(String prefix);
    List<Employee> findAllEmployeesSortByDeptNameAndEmpId();
    List<Employee> findEmployeesByDeptNameSortByEmpId(String department_name);
    Department findDeptOfEmployee(Integer employee_id);
}