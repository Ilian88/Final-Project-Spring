package com.example.healthy_way.web;

import com.example.healthy_way.exception.DatabaseNotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    String errorMessage;

    @GetMapping("/error")
    public String handleDatabaseNotFound(Model model, HttpServletRequest req) {

        Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status == HttpStatus.BAD_REQUEST){
            errorMessage = "Bad request , please check again what you are looking for!";
        } else if (status == HttpStatus.UNAUTHORIZED) {
            errorMessage = "Sorry , you don't have permission to view this page";
        } else if (status == HttpStatus.FORBIDDEN){
            errorMessage = "Sorry , we can t show you content at this time";
        } else if (status == HttpStatus.NOT_FOUND) {
            errorMessage = "This element is missing or no longer available!";
        } else {
            errorMessage = "Something went wrong! Our Engineers are on it";
        }

        model.addAttribute("message",errorMessage);

        return "error";
    }

    @ExceptionHandler({DatabaseNotFoundException.class})
    public String databaseNotFound(Model model, DatabaseNotFoundException ex) {

        errorMessage = ex.getMessage();
        model.addAttribute("message",errorMessage);

        return "error";
    }

    @ExceptionHandler({Exception.class})
    public String allOthers(Model model, Exception ex) {

        errorMessage = ex.getMessage();
        model.addAttribute("message",errorMessage);

        return "error";
    }

}
