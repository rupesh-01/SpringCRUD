package com.rupesh.springboot.cruddemo.dao;

import com.rupesh.springboot.cruddemo.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByOrderByFirstNameAsc();

}
