package ru.bulish.spring.test_task;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Class TestTaskApplication is an entry point of the app
 * Before start it migrates the script for database
 * @author Spring Boot
 */
@SpringBootApplication
public class TestTaskApplication {
    static {
        System.setProperty("Log4jContextSelector",
                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
    }
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/test_db?useUnicode=true&characterEncoding=utf8",
                        "postgres", "password")
                .load();
        flyway.migrate();
        SpringApplication.run(TestTaskApplication.class, args);

    }

}
