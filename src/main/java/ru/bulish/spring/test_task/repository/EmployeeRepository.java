package ru.bulish.spring.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bulish.spring.test_task.entity.Employee;

/**
 * Interface EmployeeRepository is a repository layer that is responsible for communication with employee table
 * using Data JPA
 * @author Spring Data
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
