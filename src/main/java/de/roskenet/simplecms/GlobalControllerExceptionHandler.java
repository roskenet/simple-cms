package de.roskenet.simplecms;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * This type of exception handling is only possible with exceptions from inside a controller.
 * This leads to the effect, that we need to catch Exceptions thrown from the view in a different way.
 * See: ExceptionFilter
 * 
 * How can this be done in a more 'nicer' way???
 * 
 * @author felix
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

	@Resource
	private Map<String, String> staticValues;
    
    @ExceptionHandler(FileNotFoundException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
            ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
            response.setStatus(404);
        mav.addAllObjects(staticValues); 
        mav.addObject("datetime", new Date());
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        return mav;
    }
}
