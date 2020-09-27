package com.gurutu.gurututechserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurutu.gurututechentity.GurutuTechLoanEntity;
import com.gurutu.gurututechrepository.GurutuTechLoanRepository;
import com.gurutu.gurututechservice.GurutuTechLoanService;

@Service
public class GurutuTechLoanServiceImpl implements GurutuTechLoanService {

	@Autowired
	GurutuTechLoanRepository gtr;
	
	@Override
	public int addLoanDetails(List<GurutuTechLoanEntity> gurutuTechLoanEntities) {
		gtr.saveAll( gurutuTechLoanEntities);
		return 1;
	}

	@Override
	public GurutuTechLoanEntity getLoan(Integer loanId) {
		GurutuTechLoanEntity gte=gtr.findAllByLoanId(loanId);
		return gte;
	}

	@Override
	public List<GurutuTechLoanEntity> getAllLoan() {
		List<GurutuTechLoanEntity> entities=gtr.findAll();
		
		return entities;
	}

}
