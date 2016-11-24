package de.roskenet.simplecms.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import de.roskenet.simplecms.AbstractSCMSController;
import de.roskenet.simplecms.entity.Page;
import de.roskenet.simplecms.entity.PageTag;
import de.roskenet.simplecms.entity.Tag;
import de.roskenet.simplecms.repository.PageRepository;

@RestController
public class ApiTagController extends AbstractSCMSController {

	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private EntityManager entityManager;

	@RequestMapping(value="/api/pages", method=RequestMethod.GET)
	public List<Page> getPages(final HttpServletRequest req) {
		return pageRepository.findAll();
	}
	
	@RequestMapping(value="/api/pages/**/tags", method=RequestMethod.GET)
	public List<String> getTags(final HttpServletRequest req, final HttpSession session) {
		final String fullPath = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		// PathVariables can not handle slashes so we need to extract all relevant information
		// from the request by hand.
		Pattern pattern = Pattern.compile("/api/pages/(.*?)/tags");
		Matcher matcher = pattern.matcher(fullPath);
		
		if(matcher.find()) {
			String pageId = matcher.group(1);
			List<String> tagList = new ArrayList<>();
			
			pageRepository.findOne(pageId).getTags().forEach(s -> tagList.add(s.getId()));
			return tagList;
		}
		
		return Arrays.asList("");
	}
	
	@RequestMapping(value="/api/pages/**/tags", method=RequestMethod.POST)
	@Transactional
	public void postTags(final HttpServletRequest req, final HttpSession session, @RequestBody final List<String> tags) {
    final String fullPath = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		// PathVariables can not handle slashes so we need to extract all relevant information
		// from the request by hand.
		Pattern pattern = Pattern.compile("/api/pages/(.*?)/tags");
		Matcher matcher = pattern.matcher(fullPath);
		
		if(matcher.find()) {
			String pageId = matcher.group(1);
			entityManager.createNativeQuery("DELETE FROM page_tag WHERE page_id='" + pageId + "'").executeUpdate();
			tags.forEach(tag -> insertTag(pageId, tag));
		}
	}
	
	private void insertTag(final String page, final String tag) {
		Query query = entityManager.createNativeQuery("SELECT id from tag where id='" + tag +"'", Tag.class);
		try {
			query.getSingleResult();
		} catch (NoResultException nre) {
//			System.out.println(nre);
//			Query insertQuery = entityManager.createNativeQuery("INSERT INTO tag (id) VALUES ('" + tag + "'");
//			insertQuery.executeUpdate();
			Tag newTag = new Tag(tag);
			entityManager.persist(newTag);
		}
		
		PageTag pageTag = new PageTag();
		pageTag.setPageId(page);
		pageTag.setTagId(tag);
		entityManager.persist(pageTag);
	}

}
