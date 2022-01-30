package ru.bulish.spring.test_task.service;

import org.springframework.stereotype.Service;
import ru.bulish.spring.test_task.entity.Employee;

import java.util.List;

/**
 * Interface EmployeeService is a service layer that is responsible for business logic
 * @author Sorokina Aleksandra
 */
@Service
public interface EmployeeService {

    /**
     * Method gets the List of all Employees using repository layer
     * @return List of Employees
     * @see EmployeeServiceImpl
     */
    List<Employee> findAll();
    /**
     * Method saves or updates the given entity in the table using repository layer
     * @see EmployeeServiceImpl
     */
     Employee saveOrUpdate(Employee employee);
}
