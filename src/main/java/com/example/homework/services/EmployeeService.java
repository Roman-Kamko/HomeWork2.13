package com.example.homework.services;

import com.example.homework.model.Employee;

import java.math.BigDecimal;
import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, String salary, int department);

    Employee remove(String firstName, String lastName, String salary, int department);

    Employee find(String firstName, String lastName, String salary, int department);

    Collection<Employee> printAll();
}
