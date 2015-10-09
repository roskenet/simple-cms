package de.roskenet.simplecms;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	@Value("${spring.thymeleaf.prefix}")
	private String thPrefix;
	
	@RequestMapping("/*")
	public String index() {
		return "redirect:page/index.html";
	}
	
	@RequestMapping("/page/{page}")
	public String page(@PathVariable("page") String page, Model model, HttpServletRequest req, HttpSession session) throws FileNotFoundException {
		
		/*
		 * This is an ugly hack to throw a 404 when the template file is not found.
		 * Thymeleaf throws 500 - which is in my eyes wrong but I did not find a solution to catch this
		 * Exception.
		 */
		Path path = Paths.get(thPrefix.substring(5) + "/pages/" + page + ".html");
		if (Files.notExists(path)) {
		  throw new FileNotFoundException();
		}
		/*
		 * End of ugly hack.
		 */
		
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("STATIC", staticPrefix);
		model.addAllAttributes(hashMap);
		
		return "pages/" + page;
	}
	
}
