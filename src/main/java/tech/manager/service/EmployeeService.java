package tech.manager.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import tech.manager.dto.Employee;
import tech.manager.entity.EmployeeEntity;
import tech.manager.exception.EmployeeNotFoundException;
import tech.manager.repository.EmployeeRepository;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeEntity add(EmployeeEntity emp) {
        injectCode(emp);
        return employeeRepository.save(emp);
    }

    private void injectCode(EmployeeEntity emp) {
        emp.setEmployeeCode(UUID.randomUUID().toString());
    }

    public Collection<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity findById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Did not find EmployeeEntity with ID = " + id));
    }

    public Employee update(Employee emp) {
        val findEntity = findById(emp.getId());
        EmployeeEntity.update(findEntity, emp);
        return Employee.toDto(employeeRepository.save(findEntity));
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
