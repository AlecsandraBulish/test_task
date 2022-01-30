package ru.bulish.spring.test_task.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Class Department is the entity that connected to the table in a database and each field is a column
 * Also the table has connected with department table
 * @author Sorokina Aleksandra
 * @version 1.0
 */
@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
    }
    public Department() {

    }


}
