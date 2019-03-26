package de.roskenet.simplecms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.roskenet.simplecms.entity.CategoryView;

public interface CategoryViewRepository extends CrudRepository<CategoryView, String> {

	List<CategoryView> findByMainOrderByLevelDesc(String main);
}
