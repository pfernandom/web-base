package com.untitled.data.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.untitled.data.entity.Client;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepository extends CrudRepository<Client, Long> {
	List<Client> findByAlias(String alias);
	
	//@PreFilter("filterObject.createdBy.getId() == principal.id")
    @Override
    Iterable<Client> findAll(); 
    
}
