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
import ru.bulish.spring.test_task.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    void findAll() {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setDepartment(new Department("HR"));
        employee1.setHire_time(new GregorianCalendar(2022, Calendar.APRIL, 22).getTimeInMillis());
        employee1.setFired_time(new GregorianCalendar(2022, Calendar.MAY, 18).getTimeInMillis());

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setDepartment(new Department("IT"));
        employee2.setHire_time(new GregorianCalendar(2022, Calendar.DECEMBER, 22).getTimeInMillis());
        employee2.setFired_time(new GregorianCalendar(2022, Calendar.DECEMBER, 29).getTimeInMillis());

            List<Employee> employeeList = new ArrayList<>();
           employeeList.add(employee1);
           employeeList.add(employee2);

            Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);

            assertThat(employeeService.findAll()).isEqualTo(employeeList);
        }



    @Test
    void testSave() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setDepartment(new Department("HR"));
        employee.setHire_time(new GregorianCalendar(2022, Calendar.APRIL, 22).getTimeInMillis());
        employee.setFired_time(new GregorianCalendar(2022, Calendar.MAY, 18).getTimeInMillis());

        Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);

        assertThat(employeeService.saveOrUpdate(employee)).isEqualTo(employee);
    }
    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setDepartment(new Department("HR"));
        employee.setHire_time(new GregorianCalendar(2022, Calendar.APRIL, 22).getTimeInMillis());
        employee.setFired_time(new GregorianCalendar(2022, Calendar.MAY, 18).getTimeInMillis());

        Mockito.when(employeeRepository.findById(1L)).thenReturn(java.util.Optional.of(employee));

        employee.setFired_time(new GregorianCalendar(2022, Calendar.AUGUST, 22).getTimeInMillis());
        Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);

        assertThat(employeeService.saveOrUpdate(employee)).isEqualTo(employee);

    }
}