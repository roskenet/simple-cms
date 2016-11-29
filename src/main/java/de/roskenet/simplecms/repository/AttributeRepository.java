package de.roskenet.simplecms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.roskenet.simplecms.entity.Attribute;

public interface AttributeRepository extends PagingAndSortingRepository<Attribute, Integer> {

}
