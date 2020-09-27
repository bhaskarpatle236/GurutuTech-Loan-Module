 package com.gurutu.gurututechrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gurutu.gurututechentity.GurutuTechLoanEntity;


@Repository
public interface GurutuTechLoanRepository extends JpaRepository<GurutuTechLoanEntity, Integer> {

	public GurutuTechLoanEntity findAllByLoanId(Integer loanId);
}
