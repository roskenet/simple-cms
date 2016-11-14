package de.roskenet.simplecms.repository;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import de.roskenet.simplecms.entity.CategoryView;

public interface CategoryViewRepository extends CrudRepository<CategoryView, String> {

	Stream<CategoryView> findByMain(String main);
}
