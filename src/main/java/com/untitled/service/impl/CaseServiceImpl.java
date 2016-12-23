package com.untitled.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untitled.aspect.RepoAspect;
import com.untitled.data.entity.Case;
import com.untitled.data.repo.CaseRepository;
import com.untitled.service.api.CaseService;

@Service
public class CaseServiceImpl implements CaseService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CaseServiceImpl.class);
	@Autowired
	private CaseRepository repo;
	
	@Override
	public Case saveCase(Case newCase) {
		return repo.save(newCase);
	}

	@Override
	public Case getCase(Long caseId) {
		return repo.findOne(caseId);
	}

	@Override
	public List<Case> getAllCases() {
		List<Case> results = new ArrayList<Case>();
		repo.findAll().forEach(c->{results.add(c);});
		return results;
	}

	@Override
	public void deleteCase(Long caseId) {
		repo.delete(caseId);
		
	}

	@Override
	public boolean isCaseExist(Case c) {
		return !repo.findByTitle(c.getTitle()).isEmpty();
	}

}
