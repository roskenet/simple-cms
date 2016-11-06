package de.roskenet.simplecms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.roskenet.simplecms.AbstractSCMSController;
import de.roskenet.simplecms.repository.PageRepository;

@Controller
public class SecuredController extends AbstractSCMSController {

	@Autowired
	private PageRepository pageRepository;

	@RequestMapping("/secured/{path}")
	@PreAuthorize("isAuthenticated() and hasPermission(#path, 'path.to.Thing', 'read')")
	public String page(final Model model, final HttpServletRequest req, final HttpSession session) {

		return "/secured/hello";
	}

}
