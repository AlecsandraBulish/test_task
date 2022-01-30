package ru.bulish.spring.test_task.entity;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Class EmployeeHireLogger is for logging actions that made by EmployeeManager
 * @author Sorokina Aleksandra
 * @version 1.0
 */
@Data
@Component
public class EmployeeHireLogger {
    private final Logger logger = LogManager.getLogger(EmployeeHireLogger.class);

    public void performSomeTask(){
        logger.debug("This is a debug message.");
        logger.info("This is an info message.");
        logger.warn("This is a warn message.");
        logger.error("This is an error message.");
        logger.fatal("This is a fatal message.");
    }
}
