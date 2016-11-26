package de.roskenet.simplecms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.roskenet.simplecms.entity.Suser;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface SuserRepository extends PagingAndSortingRepository<Suser, String>{

}
