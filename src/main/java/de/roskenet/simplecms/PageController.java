package de.roskenet.simplecms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@Value("${spring.thymeleaf.prefix}")
	private String prefix;
	
	@RequestMapping("/{template}/{content}")
	public String greeting(@PathVariable("template") String template, @PathVariable("content") String content, Model model) {
		Map<String,Object> hashMap = new HashMap<String, Object>();
		
		System.out.println("Prefix: " + prefix);
		System.out.println("Template: " + template);
		
		hashMap.put("STATIC", "https://felixroskede.s3.eu-central-1.amazonaws.com");
		hashMap.put("CONTENT", "/content/" + content);
		model.addAllAttributes(hashMap);
		return "tmpl/" + template;
	}
}
