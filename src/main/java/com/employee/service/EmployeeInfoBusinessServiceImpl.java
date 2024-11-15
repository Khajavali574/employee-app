package com.employee.service;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeInfoBusinessServiceImpl implements EmployeeInfoBusinessService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository deparmentRepository;

    /*@Override
    public ArrayList<Employee> findAllEmployee() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }*/

    @Override
    public List<Employee> findAllByDepartment(String name) {
        Department department = deparmentRepository.findByName(name);
        Sort sort = Sort.by(Sort.Order.asc("name"));
        return  null!= department ? employeeRepository.findByDepartment(department,sort):null;
    }

    @Override
    public ArrayList<Employee> findAllEmployeeStartWith(String prefix) {
        return employeeRepository.findAllByNameStartingWith(prefix);
    }

    @Override
    public List<Employee> findAllEmployeesSortByDeptNameAndEmpId() {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        return  employeeRepository.findAll(sort);

    }

    @Override
    public List<Employee> findEmployeesByDeptNameSortByEmpId(String department_name) {
        Department department = deparmentRepository.findByName(department_name);
        Sort sort = Sort.by(Sort.Order.asc("department.name"), Sort.Order.asc("id"));
        return null != department ? employeeRepository.findByDepartment(department,sort):null;
    }
    @Override
    public Department findDeptOfEmployee(Integer employee_id) {
        return deparmentRepository.findByName(employeeRepository.findById(employee_id).get().getDepartment().getName()) ;
    }

    public Department createDepartmentWithEmployees(String departmentName, List<String> employeeNames) {
        Department department = new Department();
        department.setName(departmentName);
        List<Employee> employees = new ArrayList<>();
        for (String employeeName : employeeNames) {
            Employee employee = new Employee();
            employee.setName(employeeName);
            employee.setDepartment(department);
            employees.add(employee);
        }
        department.setEmployees(employees);
        return deparmentRepository.save(department);
    }

}
