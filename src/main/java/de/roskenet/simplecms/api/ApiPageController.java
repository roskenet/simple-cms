package de.roskenet.simplecms.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.roskenet.simplecms.entity.Page;
import de.roskenet.simplecms.repository.PageRepository;


/*
 * Naive quick'n'dirty implementation.
 * TODO use Spring's RepositoryRestResource Features.
 */
@RestController
public class ApiPageController {
	
	@Autowired
	private PageRepository pageRepository;
	
	class ApiPage {
		@JsonProperty("id")
		String id;
		@JsonProperty("path")
		String path;
		@JsonProperty("tags")
		Set<String> tags = new HashSet<>();
		@JsonProperty("author")
		String owner;
		@JsonProperty("category")
		String category;
	}
	
	private ApiPage mapDBPageToApiPage(Page page) {
		final ApiPage apiPage = new ApiPage();
		apiPage.id = page.getId();
		apiPage.path = page.getPath();
		if(page.getTags() != null) {
			page.getTags().forEach(e -> apiPage.tags.add(e.getId()));
		}
		apiPage.category = page.getCategoryId();
		apiPage.owner = page.getSuser().getId();
		return apiPage;
	}
	
	@RequestMapping(value = "/api/pages", method = RequestMethod.GET)
	public List<ApiPage> getPages(final HttpServletRequest req) {
		
		List<ApiPage> pages = pageRepository.findAll().stream().map(p -> mapDBPageToApiPage(p)).collect(Collectors.toList());
		
		return pages;
	}
	
	@RequestMapping(value = "/api/pages", method = RequestMethod.POST)
	public void postPage(@RequestBody ApiPage page) {
		
	}
}
