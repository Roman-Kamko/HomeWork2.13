package com.example.homework.services.impl;

import com.example.homework.model.Employee;
import com.example.homework.exceptions.EmployeeNotFoundException;
import com.example.homework.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findMaxSalaryFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMinSalaryFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> printAllFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> printAllSortedByDepartment() {
        return employeeServiceImpl.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
