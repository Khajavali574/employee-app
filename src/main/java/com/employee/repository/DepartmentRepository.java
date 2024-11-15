package com.employee.repository;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.ByteBuffer;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByName(String name);
}

