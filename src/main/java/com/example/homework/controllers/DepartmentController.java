package com.example.homework.controllers;

import com.example.homework.services.DepartmentService;
import com.example.homework.model.Employee;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}/salary/max")
    public Employee findMaxSalaryFromDepartment(@PathVariable(value = "id") int departmentId) {
        return depService.findMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee findMinSalaryFromDepartment(@PathVariable(value = "id") int departmentId) {
        return depService.findMinSalaryFromDepartment(departmentId);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> printAllFromDepartment() {
        return depService.printAllSortedByDepartment();
    }

    @GetMapping(path = "/{id}/employees")
    public Collection<Employee> printAllFromDepartment(@PathVariable(value = "id") int departmentId) {
        return depService.printAllFromDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public String printSalaryPerDepartment(@PathVariable(value = "id") int departmentId) {
        return depService.printSalaryPerDepartment(departmentId);
    }
}
