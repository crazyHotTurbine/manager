package tech.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.manager.entity.Employee;
import tech.manager.repository.EmployeeRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    private void injectCodeToEmployee(Employee emp) {
        emp.setEmployeeCode(UUID.randomUUID().toString());
    }

}
