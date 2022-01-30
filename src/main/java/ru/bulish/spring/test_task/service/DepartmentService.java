package ru.bulish.spring.test_task.service;

import org.springframework.stereotype.Service;
import ru.bulish.spring.test_task.entity.Department;

import java.util.List;

/**
 * Interface DepartmentService is a service layer that is responsible for business logic
 * @author Sorokina Aleksandra
 */
@Service
public interface DepartmentService {
     /**
      * Method gets the List of all Departments using repository layer
      * @return List of Departments
      * @see DepartmentServiceImpl
      */
     List<Department> findAll();
}
