package de.roskenet.simplecms.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.roskenet.simplecms.AbstractSCMSController;

@Controller
public class ErrorController extends AbstractSCMSController {
	
	/**
	 * This is called only from outside a controller.
	 * Usually only when thymeleaf throws an exception.
	 * 
	 * @param model
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping("/err")
	public String page(Model model, HttpServletRequest req, HttpSession session) {
		model.addAllAttributes(getStaticValues());
		return "error";
	}
}
