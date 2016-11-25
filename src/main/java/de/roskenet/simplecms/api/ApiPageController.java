package de.roskenet.simplecms.api;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.entity.Page;
import de.roskenet.simplecms.entity.Sgroup;
import de.roskenet.simplecms.entity.Suser;
import de.roskenet.simplecms.repository.PageRepository;


/*
 * Naive quick'n'dirty implementation.
 * TODO use Spring's RepositoryRestResource Features.
 */
@RestController
public class ApiPageController {
	
	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private EntityManager em;
	

	
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
	private Page mapApiPageToDBPage(final ApiPage apiPage) {
		Page page = new Page(apiPage.id);
		Suser suser = new Suser(apiPage.owner);
		Sgroup sgroup = new Sgroup("ANONYMOUS_USERS");
		page.setSuser(suser);
		page.setSgroup(sgroup);
		page.setCreated(new Date());
		
		page.setId(apiPage.id);
		page.setPath(apiPage.path);
		page.setCategoryId(apiPage.category);
		
		return page;
	}
	
	@RequestMapping(value = "/api/pages", method = RequestMethod.GET)
	public List<ApiPage> getPages(final HttpServletRequest req) {
		
		List<ApiPage> pages = pageRepository.findAll().stream().map(p -> mapDBPageToApiPage(p)).collect(Collectors.toList());
		
		return pages;
	}
	
	@RequestMapping(value = "/api/pages", method = RequestMethod.POST)
	@Transactional
	public void postPage(@RequestBody final ApiPage page) {
		Page dbPage = mapApiPageToDBPage(page);
		em.persist(dbPage);
	}
	
	@RequestMapping(value = "/api/pages/**", method = RequestMethod.DELETE)
	@Transactional
	public void deletePage(final HttpServletRequest req) {
		final String fullPath = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		Pattern pattern = Pattern.compile("/api/pages/(.*?)$");
		Matcher matcher = pattern.matcher(fullPath);

		if (matcher.find()) {
			String pageId = matcher.group(1);
			em.createNativeQuery("DELETE FROM page WHERE id='" + pageId + "'").executeUpdate();
		}
	}
}
