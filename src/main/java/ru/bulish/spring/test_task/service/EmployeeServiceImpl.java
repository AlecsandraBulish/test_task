package ru.bulish.spring.test_task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bulish.spring.test_task.entity.Employee;
import ru.bulish.spring.test_task.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Class EmployeeServiceImpl is a service layer that is responsible for business logic
 * @author Sorokina Aleksandra
 */
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;



    @Override
    @Transactional
    public List<Employee> findAll() {
      return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }
}
