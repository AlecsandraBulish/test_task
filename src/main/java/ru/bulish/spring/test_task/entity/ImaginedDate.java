package ru.bulish.spring.test_task.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Class ImaginedDate is a component that keeps filled dates
 * @author Sorokina Aleksandra
 * @version 1.0
 */
@Data
@Component
public class ImaginedDate {
    @NotNull(message = "The date can't be empty")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date imaginedCurrentTime;

    @NotNull(message = "The date can't be empty")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date imaginedFinishTime;

}
