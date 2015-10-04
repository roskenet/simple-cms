package de.roskenet.simplecms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String root() {
		return "index";
	}
	
	@RequestMapping("/{content}")
	public String greeting(@PathVariable("content") String content, Model model, HttpSession session) {

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
	
}
