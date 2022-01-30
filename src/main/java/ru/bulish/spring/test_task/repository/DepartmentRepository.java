package ru.bulish.spring.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bulish.spring.test_task.entity.Department;

import java.util.List;

/**
 * Interface DepartmentRepository is a repository layer that is responsible for communication with department table
 * using Data JPA
 * @author Spring Data
 */
@Repository
public interface DepartmentRepository extends  JpaRepository<Department, Long> {
    @Query(value = "SELECT d FROM Department d")
    List<Department> getAllDepartments();
}
