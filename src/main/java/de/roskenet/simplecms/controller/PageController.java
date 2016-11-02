package de.roskenet.simplecms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.AbstractSCMSController;
import de.roskenet.simplecms.entity.Page;
import de.roskenet.simplecms.repository.PageRepository;

@Controller
public class PageController extends AbstractSCMSController {

	@Autowired
	private PageRepository pageRepository;

	@RequestMapping("/page/**")
	public String page(final Model model, final HttpServletRequest req, final HttpSession session) {
		final String fullPath = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		Page page = pageRepository.findOne(filterSuffix(fullPath));
		if (page != null) {
			model.addAttribute("page", page);
		}

		model.addAllAttributes(getStaticValues());
		model.addAttribute("request", req);

		if (!session.isNew()) {
		    HttpSession theSession = session;
			model.addAttribute("session", theSession);
		}

		return filterSuffix(fullPath);
	}

	private String filterSuffix(final String fullPath) {
		return fullPath.substring(0, fullPath.lastIndexOf('.'));
	}

}
