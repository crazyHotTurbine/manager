package tech.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.manager.entity.EmployeeEntity;
import tech.manager.repository.EmployeeRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeEntity addEmployee(EmployeeEntity emp) {
        return employeeRepository.save(emp);
    }

    private void injectCodeToEmployee(EmployeeEntity emp) {
        emp.setEmployeeCode(UUID.randomUUID().toString());
    }

}
