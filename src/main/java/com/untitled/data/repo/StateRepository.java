package com.untitled.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.untitled.data.entity.State;


@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StateRepository extends CrudRepository<State, Long> {
	    
}
