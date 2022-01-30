package ru.bulish.spring.test_task.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Class Employee is the entity that connected to the table in a database and each field is a column
 * Also the table has connected with department table
 * @author Sorokina Aleksandra
 * @version 1.0
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private Long hire_time;
    @Column
    private Long fired_time;

    public Employee() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;


}
