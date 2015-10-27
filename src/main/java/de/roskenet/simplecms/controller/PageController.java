package de.roskenet.simplecms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.AbstractSCMSController;

@Controller
public class PageController extends AbstractSCMSController{

	@RequestMapping("/page/**")
	public String page(Model model, HttpServletRequest req, HttpSession session) {
	    String fullPath = (String) req.getAttribute(
	            HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
	    
		model.addAllAttributes(getStaticValues());
		model.addAttribute("request", req);
		
//		if(!session.isNew()) {
//			model.addAttribute("session", session);
//		}

		return filterSuffix(fullPath);
	}

	private String filterSuffix(String fullPath) {
		return fullPath.substring(0, fullPath.lastIndexOf('.'));
	}
	
}
