package com.untitled.data.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.untitled.data.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByName(String name);
}
