package com.employee.repository;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(Department department, Sort sort);
    ArrayList<Employee> findAllByNameStartingWith(String prefix);
    //ArrayList<Employee> findByDepartmentDepartment_name(String department_name);




    /*
    @Query("SELECT e FROM Employee e WHERE e.department_name = :department_name order by e.employee_number")
    ArrayList<Employee> findAllEmployeesByDepartment(String department_name);
    @Query("SELECT e FROM Employee e WHERE e.employee_name LIKE %:startWith%")
    ArrayList<Employee> findAllEmployeesStartsWith(String startWith);
    @Query("SELECT e FROM Employee e order by e.department_name,e.employee_number")
    ArrayList<Employee> findAllEmployeesSortByDeptNameAndEmpId();
    @Query("SELECT e FROM Employee e where e.department_name=:department_name order by e.employee_number")
    ArrayList<Employee> findEmployeesByDeptNameSortByEmpId(String department_name);
    @Query("SELECT e.department_name FROM Employee e where e.employee_number=:employee_number")
    Employee findDeptOfEmployee(Integer employee_number);
     */
}