package tech.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.manager.entity.EmployeeEntity;
import tech.manager.exception.EmployeeNotFoundException;
import tech.manager.repository.EmployeeRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeEntity add(EmployeeEntity emp) {
        return employeeRepository.save(emp);
    }

    private void injectCode(EmployeeEntity emp) {
        emp.setEmployeeCode(UUID.randomUUID().toString());
    }

    private Collection<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    private EmployeeEntity findById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new EmployeeNotFoundException(String.format("Did not find EmployeeEntity with ID = %s", id))
                );
    }

    private EmployeeEntity update(EmployeeEntity emp) {
        return employeeRepository.save(emp);
    }

    private void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
