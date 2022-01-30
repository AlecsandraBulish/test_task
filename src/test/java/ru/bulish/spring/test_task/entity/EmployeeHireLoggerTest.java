package ru.bulish.spring.test_task.entity;

import org.junit.jupiter.api.Test;

class EmployeeHireLoggerTest {

    @Test
    public void testPerformSomeTask() throws Exception {
        EmployeeHireLogger log4J2AsyncLogger= new EmployeeHireLogger();
        log4J2AsyncLogger.performSomeTask();
    }
}