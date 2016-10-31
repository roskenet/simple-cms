package de.roskenet.simplecms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.roskenet.simplecms.entity.Page;

public interface PageRepository extends CrudRepository<Page, String>{

//	@Query("select p from Page p where :tagid member of p.tags")
//	List<Page> getPageByTag(@Param("tagid") String id);
	
	List<Page> getPageByTagsIdContains(String id);
}
