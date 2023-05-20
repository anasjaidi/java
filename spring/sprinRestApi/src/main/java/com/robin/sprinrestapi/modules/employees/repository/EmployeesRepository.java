package com.robin.sprinrestapi.modules.employees.repository;

import com.robin.sprinrestapi.modules.employees.entity.Employee;

import java.util.List;

public interface EmployeesRepository {

    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
