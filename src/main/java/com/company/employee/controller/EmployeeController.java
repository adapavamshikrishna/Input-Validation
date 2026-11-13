package com.company.employee.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.company.employee.dto.EmployeeRequestDTO;
import com.company.employee.dto.EmployeeResponseDTO;
import com.company.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDTO create(@Valid @RequestBody EmployeeRequestDTO request) {
        return employeeService.create(request);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO update(@PathVariable Long id,
                                      @Valid @RequestBody EmployeeRequestDTO request) {
        return employeeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
