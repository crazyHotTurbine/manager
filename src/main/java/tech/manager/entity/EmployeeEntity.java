package tech.manager.entity;

import lombok.*;
import tech.manager.dto.Employee;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "employee")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "phone")
    private String phone;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "employee_code", nullable = false)
    private String employeeCode;

    public static EmployeeEntity create(Employee emp) {
        return EmployeeEntity.builder()
                .name(emp.getName())
                .email(emp.getEmail())
                .jobTitle(emp.getJobTitle())
                .phone(emp.getPhone())
                .imageUrl(emp.getImageUrl())
                .employeeCode(emp.getEmployeeCode())
                .build();
    }

    public static void update(EmployeeEntity entity, Employee emp) {
        entity.setName(emp.getName());
        entity.setEmail(emp.getEmail());
        entity.setJobTitle(emp.getJobTitle());
        entity.setPhone(emp.getPhone());
        entity.setImageUrl(emp.getImageUrl());
        entity.setEmployeeCode(emp.getEmployeeCode());
    }
}
