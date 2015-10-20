package de.roskenet.simplecms.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.roskenet.simplecms.AbstractSCMSController;

@Controller
public class PageController extends AbstractSCMSController{

	@RequestMapping("/page/{page}")
	public String page(@PathVariable("page") String page, Model model, HttpServletRequest req, HttpSession session) throws FileNotFoundException {

		model.addAllAttributes(getStaticValues());
		
		return "pages/" + page;
	}
	
}
