package ru.bulish.spring.test_task.service;

import org.springframework.stereotype.Service;
import ru.bulish.spring.test_task.entity.Department;
import ru.bulish.spring.test_task.repository.DepartmentRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Class DepartmentServiceImpl is a service layer that is responsible for business logic
 * @author Sorokina Aleksandra
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    @Transactional
    public List<Department> findAll() {
         List<Department> departments = departmentRepository.getAllDepartments();
         return departments;

    }
}
