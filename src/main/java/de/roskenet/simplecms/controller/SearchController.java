package de.roskenet.simplecms.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.roskenet.simplecms.AbstractSCMSController;
import de.roskenet.simplecms.entity.Page;
import de.roskenet.simplecms.repository.PageRepository;

@Controller
public class SearchController extends AbstractSCMSController {

	@Autowired
	private PageRepository pageRepository;
	
	@RequestMapping("/search")
	public String page(Model model, HttpServletRequest req, HttpSession session) {
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		if(parameterMap.containsKey("tag")) {
			String searchTag = parameterMap.get("tag")[0];
			List<Page> pageByTags = pageRepository.getPageByTagsIdContains(searchTag).collect(Collectors.toList());
			model.addAttribute("result", pageByTags);
		}
		
		model.addAllAttributes(getStaticValues());
		model.addAttribute("request", req);
		
		return "search";
	}
}
