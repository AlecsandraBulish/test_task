package ru.bulish.spring.test_task.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bulish.spring.test_task.entity.*;
import ru.bulish.spring.test_task.entity.EmployeeHireLogger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


/**
 * Class EmployeeManager is a main component that responsible for creating,hiring and firing employees
 * Also it has access to service layer for connecting to database in order to update, save or get information
 * @author Sorokina Aleksandra
 * @version 1.0
 */
@Data
@Service
public class EmployeesManager {
    /**
     * Field hireLogger is responsible for logging all required actions
     * @see EmployeeHireLogger
     */
    @Autowired
    private EmployeeHireLogger hireLogger;
    /**
     * Field departmentService is responsible for service layer
     * @see DepartmentService
     */
    @Autowired
    private DepartmentService departmentService;
    /**
     * Field employeeService is responsible for service layer
     * @see EmployeeService
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Field imaginedDate keeps the date that gotten from the form
     * @see ImaginedDate
     */
    private ImaginedDate imaginedDate;

    /**
     * Field calendar_start is for keeping the current date
     * @see Calendar
     */
    private Calendar calendar_start;
    /**
     * Field calendar_start for keeping the finish date
     * @see Calendar
     */
    private Calendar calendar_finish;
    /**
     * Field format1 for making formatting date to required view
     * @see SimpleDateFormat
     */
    private SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);

    /**
     * Method instantiates dates before starting
     */
    private void instantiateDates() {
        calendar_start = new GregorianCalendar();
        calendar_start.setTime(imaginedDate.getImaginedCurrentTime());
        calendar_finish = new GregorianCalendar();
        calendar_finish.setTime(imaginedDate.getImaginedFinishTime());
    }

    /**
     * Method creates employee each second with saving to database and setting hire_time
     * Each five iterations happens random firing of random amount of employees by invoking two methods
     * first one is generateRandomNum() that is responsible for generating random number according to range
     * second one is fire() that is responsible for firing of random amount of employees
     */
    public void createEmployee() throws InterruptedException {
        instantiateDates();
        int countHiredEmps = 0;
        while (!calendar_start.equals(calendar_finish)){
            Employee employee = new Employee();
            employee.setHire_time(generateRandomNum(calendar_start.getTimeInMillis(),calendar_finish.getTimeInMillis()));
            List<Department> departments = departmentService.findAll();
            employee.setDepartment(departments.get((int) generateRandomNum(0, departments.size())));
            employeeService.saveOrUpdate(employee);
            countHiredEmps++;

            hireLogger.getLogger().info(String.format("{%s}:ID:%d HIRED - {%s} Department: %s ",format1.format(calendar_start.getTimeInMillis()), employee.getId(),
                       format1.format(employee.getHire_time()),employee.getDepartment().getName()));
            Thread.sleep(1000);
            calendar_start.set(Calendar.DAY_OF_MONTH,calendar_start.get(Calendar.DAY_OF_MONTH) + 1);
            if (countHiredEmps == 5) {
                long count = generateRandomNum(1,3);
                fire(count);
                countHiredEmps=0;
            }
        }
    }
    /**
     * Method generates a value in a given range
     * @param min is minimum range for generating from
     * @param max is maximum range for generating till
     * @return generated long value according a range
     * @see Math
     */
    private long generateRandomNum(long min, long max) {
       return  (long) ((Math.random() * (max - min)) + min);
    }

    /**
     * Method sets a random time of firing an employee
     * @param count is a random amount of employees that has to be fired
    */
    private void fire(long count) {
        List<Employee> employees = employeeService.findAll();
        for (int i = 0; i <= count; i++) {
           Employee employee = employees.get((int) generateRandomNum(0, employees.size()));
           employee.setFired_time(generateRandomNum(employee.getHire_time(),calendar_finish.getTimeInMillis()));
           employeeService.saveOrUpdate(employee);
           hireLogger.getLogger().info(String.format("{%s}: ID:%d FIRED - {%s} Department: %s Worked days:%s ",format1.format(calendar_start.getTimeInMillis()), employee.getId(),
                    format1.format(employee.getFired_time()),employee.getDepartment().getName(),getWorkedDays(employee)));
        }
    }
    /**
     * Method gets the hire and fire time of the given employee afterwards it calculates the difference that
     * is an amount of worked days
     * @param employee is a specific employee that was fired and needs to get his worked days
     * @return String that is formatted value given after calculation
     * @see String
     */
    private String getWorkedDays(Employee employee) {
        long days = employee.getFired_time() - employee.getHire_time();
        String str = String.format("%d", TimeUnit.MILLISECONDS.toDays(days));
        return str;
    }
}
