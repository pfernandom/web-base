package com.untitled.data.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import com.untitled.data.entity.Case;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "cases", path = "cases")
public interface CaseRepository extends PagingAndSortingRepository<Case, Long> {
	List<Case> findByTitle(String title);
	
	//@PreFilter("filterObject.createdBy.getId() == principal.id")
    @Override
    Iterable<Case> findAll(); 
    
}
