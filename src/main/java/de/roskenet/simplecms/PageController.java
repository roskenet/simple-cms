package de.roskenet.simplecms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@Value("${static.prefix}")
	private String staticPrefix;

	@Value("${template}")
	private String template;
	
	@RequestMapping("/")
	public String root(HttpServletRequest req, HttpSession session) {
		logMeOut(req);
		return "index";
	}
	
	@RequestMapping("/{content}")
	public String greeting(@PathVariable("content") String content, Model model, HttpServletRequest req, HttpSession session) {
		logMeOut(req);
		if(content.equals("index") || content.equals("index.html")) {
			return "index";
		}
		
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("CONTENT", content);
		hashMap.put("STATIC", staticPrefix);
		hashMap.put("SESSION", session);
		model.addAllAttributes(hashMap);
		return template;
	}

	private void logMeOut(HttpServletRequest req) {
		System.out.println("REQUEST:");
		System.out.println(new Date());
		System.out.println(req.getRequestURL());
		System.out.println(req.getRemoteAddr());
	}
	
}
