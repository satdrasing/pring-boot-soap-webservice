package io.satendra.springbootsoapwebservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {

    @Id
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_dept")
    private String employeeDept;
}
