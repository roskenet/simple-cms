package de.roskenet.simplecms.repository;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import de.roskenet.simplecms.entity.Page;

public interface PageRepository extends CrudRepository<Page, String>{

	Stream<Page> getPageByTagsIdContains(String id);
}
