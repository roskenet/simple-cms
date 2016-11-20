package de.roskenet.simplecms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.AbstractSCMSController;
import de.roskenet.simplecms.repository.PageRepository;

@RestController
public class SecuredController extends AbstractSCMSController {

	@Autowired
	private PageRepository pageRepository;

	@RequestMapping(value="/api/**", method=RequestMethod.GET)
	public String page(final HttpServletRequest req, final HttpSession session) {
		final String fullPath = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		// PathVariables can not handle slashes so we need to extract all relevant information
		// from the request by hand.
		
		return fullPath;
	}

}
