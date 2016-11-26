package de.roskenet.simplecms.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.AbstractSCMSController;
import de.roskenet.simplecms.entity.CategoryView;
import de.roskenet.simplecms.entity.Page;
import de.roskenet.simplecms.repository.CategoryViewRepository;
import de.roskenet.simplecms.repository.PageRepository;

@Controller
public class PageController extends AbstractSCMSController {

	@Autowired
	private RequestLogger requestLogger;
	
	@Autowired
	private PageRepository pageRepository;

	@Autowired
	private CategoryViewRepository categoryViewRepository;
	
	@RequestMapping("/page/**")
	public String page(final Model model, final HttpServletRequest req, final HttpSession session) {
		final String fullPath = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		final Page page = pageRepository.findOne(filterSuffix(fullPath));
		if (page != null) {
			model.addAttribute("page", page);
			
			List<CategoryView> categories = categoryViewRepository.findByMainOrderByLevelDesc(page.getCategoryId()).collect(Collectors.toList());
			model.addAttribute("categories", categories);
		}

		model.addAllAttributes(getStaticValues());
		model.addAttribute("request", req);

//		if (!session.isNew()) {
//		    HttpSession theSession = session;
//			model.addAttribute("session", theSession);
//		}

		requestLogger.writeLog(req);
		if(page != null) {
			return page.getPath(); 			
		}
		else {
			return "/page/" + filterSuffix(fullPath);
		}
	}

	private String filterSuffix(final String fullPath) {
//		return fullPath.substring(0, fullPath.lastIndexOf('.'));
		Pattern pattern = Pattern.compile("/page/(.*?)\\.html");
		Matcher matcher = pattern.matcher(fullPath);
		
		if(matcher.find()) {
			String pageId = matcher.group(1);
			return pageId;
		}
		return "";
	}

}
