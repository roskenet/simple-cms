package de.roskenet.simplecms;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(TemplateInputException.class)
    public void thymeleafeTemplateException(/* HttpServletRequest req, Exception exception */) {
    	/*
        ModelAndView mav = new ModelAndView();
        mav.addObject("errormessage", "Diese Seite existiert nicht.");
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
        */
    }
    
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, RuntimeException e) {
            ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

        mav.addObject("datetime", new Date());
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        return mav;
    }
}
