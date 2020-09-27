package com.gurutu.gurututechservice;

import java.util.List;

import com.gurutu.gurututechentity.GurutuTechLoanEntity;

public interface GurutuTechLoanService {
	
	public int addLoanDetails(List<GurutuTechLoanEntity> gurutuTechLoanEntities);
	public GurutuTechLoanEntity getLoan(Integer loanId);
    public List<GurutuTechLoanEntity> getAllLoan();
}
