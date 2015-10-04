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
	
	@Value("${spring.thymeleaf.prefix}")
	private String prefix;

	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String greeting(@PathVariable("page") String content, Model model, HttpSession session) {

		if(content.equals("index") || content.equals("index.html")) {
			return "index";
		}
		
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("CONTENT", content);
		hashMap.put("STATIC", "https://s3.eu-central-1.amazonaws.com/felixroskede/");
		model.addAllAttributes(hashMap);
		return "page";
	}
	
}
