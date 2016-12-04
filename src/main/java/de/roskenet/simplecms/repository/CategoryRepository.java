package de.roskenet.simplecms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.roskenet.simplecms.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {

}
