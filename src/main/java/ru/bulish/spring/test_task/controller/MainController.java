package ru.bulish.spring.test_task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bulish.spring.test_task.entity.ImaginedDate;
import ru.bulish.spring.test_task.service.EmployeesManager;

import javax.validation.Valid;


/**
 * Class Controller is for displaying main pages and to enter preferred date
 * @author Sorokina Aleksandra
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
public class MainController {

    /**
     * Field manager is intended to start implementing the main functional of the app- to create
     * hire and fire employees
     * @see EmployeesManager
     */
    @Autowired
    private  EmployeesManager manager;


    /**
     * Method show the view with the form that has to be filled in order to run the app
     * @param model is responsible for interacting between Controller and View in order to keep variables
     * for representing them in a view
     * @return view html
     * @see ImaginedDate
     */
    @GetMapping("/")
    public String getStarted(Model model){
        model.addAttribute("imagineDate", new ImaginedDate());
        return "date_form";
    }

    /**
     * Method firstly check if the form was filled properly if not it returns the same form with
     * clarification but if everything is correct the app starts working the way it's intended to be
     * @param imaginedDate keeps the object that was created by filling the form
     * @param result keeps possible errors that might have happened during filling the form
     * for representing them in a view
     * @return view html
     * @see EmployeesManager
     */
    @PostMapping("/date")
    public String date(@Valid @ModelAttribute("imagineDate") ImaginedDate imaginedDate, BindingResult result) {
        if (result.hasErrors()) {
            return "/date_form";
        }
            manager.setImaginedDate(imaginedDate);
            try {
                manager.createEmployee();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "redirect:/";
        }


    }



