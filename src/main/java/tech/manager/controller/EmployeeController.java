package tech.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.manager.dto.Employee;
import tech.manager.entity.EmployeeEntity;
import tech.manager.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    private ResponseEntity<Employee> create(@RequestBody Employee emp) {
        val entity = employeeService.add(EmployeeEntity.create(emp));
        return new ResponseEntity<Employee>(Employee.toDto(entity), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll() {
        val employeeResponses = employeeService.findAll()
                .stream()
                .map(Employee::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(employeeResponses);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(Employee.toDto(employeeService.findById(id)));
    }

    @PutMapping("update")
    public ResponseEntity<Employee> update(@RequestBody Employee emp) {
        return ResponseEntity.ok(employeeService.update(emp));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        employeeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
