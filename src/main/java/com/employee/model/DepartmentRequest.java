package com.employee.model;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentRequest {
    private String departmentName;
    private List<String> employeeNames;
}
