package ru.bulish.spring.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bulish.spring.test_task.entity.Department;
import ru.bulish.spring.test_task.entity.Employee;
import ru.bulish.spring.test_task.repository.DepartmentRepository;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentServiceImplTest {

@Autowired
private DepartmentService departmentService;

@MockBean
private DepartmentRepository departmentRepository;
    @Test
    void findAll() {
        Department department1 = new Department();
        department1.setId(1L);
        department1.setName("HR");
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setDepartment(department1);
        employee1.setHire_time(new GregorianCalendar(2022, Calendar.APRIL, 22).getTimeInMillis());
        employee1.setFired_time(new GregorianCalendar(2022, Calendar.MAY, 18).getTimeInMillis());
        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setDepartment(department1);
        employee2.setHire_time(new GregorianCalendar(2022, Calendar.DECEMBER, 22).getTimeInMillis());
        employee2.setFired_time(new GregorianCalendar(2022, Calendar.DECEMBER, 29).getTimeInMillis());
        List<Employee> employeeList1 = new ArrayList<>(Arrays.asList(employee1,employee2));
        department1.setEmployeeList(employeeList1);

        Department department2 = new Department();
        department2.setId(2L);
        department2.setName("IT");
        Employee employee3 = new Employee();
        employee1.setId(3L);
        employee1.setDepartment(department2);
        employee1.setHire_time(new GregorianCalendar(2022, Calendar.APRIL, 11).getTimeInMillis());
        employee1.setFired_time(new GregorianCalendar(2022, Calendar.MAY, 18).getTimeInMillis());
        Employee employee4 = new Employee();
        employee2.setId(4L);
        employee2.setDepartment(department2);
        employee2.setHire_time(new GregorianCalendar(2022, Calendar.DECEMBER, 20).getTimeInMillis());
        employee2.setFired_time(new GregorianCalendar(2022, Calendar.DECEMBER, 21).getTimeInMillis());
        List<Employee> employeeList2 = new ArrayList<>(Arrays.asList(employee3,employee4));
        department1.setEmployeeList(employeeList2);

        department2.setEmployeeList(null);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department1);
        departmentList.add(department2);

        Mockito.when(departmentRepository.getAllDepartments()).thenReturn(departmentList);

        assertThat(departmentService.findAll()).isEqualTo(departmentList);
        }


    }
