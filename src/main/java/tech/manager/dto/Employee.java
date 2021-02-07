package tech.manager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tech.manager.entity.EmployeeEntity;

@Builder
@Getter
@Setter
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;

    public static Employee toDto(EmployeeEntity emp) {
        return Employee.builder()
                .id(emp.getId())
                .name(emp.getName())
                .email(emp.getEmail())
                .jobTitle(emp.getJobTitle())
                .phone(emp.getPhone())
                .imageUrl(emp.getImageUrl())
                .employeeCode(emp.getEmployeeCode())
                .build();
    }
}
