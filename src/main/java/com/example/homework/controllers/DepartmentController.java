package com.example.homework.controllers;

import com.example.homework.services.DepartmentService;
import com.example.homework.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    private final DepartmentService depService;

    public DepartmentController(DepartmentService depService) {
        this.depService = depService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryFromDepartment(@RequestParam int departmentId) {
        return depService.findMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalaryFromDepartment(@RequestParam int departmentId) {
        return depService.findMinSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printAllFromDepartment() {
            return depService.printAllSortedByDepartment();
    }

    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> printAllFromDepartment(@RequestParam Integer departmentId) {
        return depService.printAllFromDepartment(departmentId);
    }
}
