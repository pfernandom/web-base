package com.untitled.service.api;

import java.util.List;

import com.untitled.data.entity.Case;

public interface CaseService {
	public Case saveCase(Case newCase);
	public Case getCase(Long caseId);
	public List<Case> getAllCases();
	public void deleteCase(Long caseId);
	public boolean isCaseExist(Case c);
}
