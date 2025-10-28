package com.example.ems.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee e) {
        return repository.save(e);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee e) {
        e.setId(id);
        return repository.save(e);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }
}
