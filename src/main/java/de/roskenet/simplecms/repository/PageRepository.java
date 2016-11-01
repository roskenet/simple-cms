package de.roskenet.simplecms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.roskenet.simplecms.entity.Page;

public interface PageRepository extends CrudRepository<Page, String>{

	List<Page> getPageByTagsIdContains(String id);
}
