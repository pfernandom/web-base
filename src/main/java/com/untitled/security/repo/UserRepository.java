package com.untitled.security.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.untitled.security.entity.User;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUserName(String username);
}
