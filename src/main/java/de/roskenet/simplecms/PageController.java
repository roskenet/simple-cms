package de.roskenet.simplecms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@Value("${static.prefix}")
	private String staticPrefix;

	@RequestMapping({"/", "index"})
	public String index() {
		return "redirect:page/index.html";
	}
	
	@RequestMapping("/page/{page}")
	public String page(@PathVariable("page") String page, Model model, HttpServletRequest req, HttpSession session) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("STATIC", staticPrefix);
		model.addAllAttributes(hashMap);
		
		return "pages/" + page;
	}
	
    //@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(Exception.class)
    public String thymeleafeTemplateException(Model model, HttpServletRequest req, HttpSession session) {
    	
    	model.addAttribute("errormessage", "Page not Found");
    	
    	return "error";
    }
    
    @ExceptionHandler(Exception.class)
	public ModelAndView handleCustomException(Exception ex) {

		ModelAndView model = new ModelAndView("error");
		model.addObject("exception", ex);
		return model;

	}
}
