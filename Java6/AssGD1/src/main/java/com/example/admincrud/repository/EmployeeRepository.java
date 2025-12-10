package com.example.admincrud.repository;
import com.example.admincrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long>{}
