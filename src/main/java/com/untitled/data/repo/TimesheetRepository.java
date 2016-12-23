package com.untitled.data.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.untitled.data.entity.Timesheet;


@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "timesheets", path = "timesheets")
public interface TimesheetRepository extends PagingAndSortingRepository<Timesheet, Long> {

}
