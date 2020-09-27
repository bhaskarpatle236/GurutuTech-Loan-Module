package com.gurutu.gurututechcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gurutu.gurututechentity.GurutuTechLoanEntity;

import com.gurutu.gurututechservice.GurutuTechLoanService;


@RestController
@RequestMapping("/loanModule")
public class GurutuTechLoanController {
	
	@Autowired
	GurutuTechLoanService gts;
	
	@Autowired
	RestTemplate rs;
	
	@GetMapping("/getAllUsersFromUser")
	private ResponseEntity<List<GurutuTechLoanEntity>> getAllUsers()
	{
		List<GurutuTechLoanEntity> entities=rs.getForObject("http://localhost:8089/gurutuTechUser/getAllData", List.class);
		return new ResponseEntity<List<GurutuTechLoanEntity>>(entities, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/addLoanDetails")
	private ResponseEntity<String> addLoanDetails(@RequestBody List<GurutuTechLoanEntity> loans)
	{
		if(!loans.isEmpty())
		{
			gts.addLoanDetails(loans);
			return new ResponseEntity<String>("All loans added succesfully", HttpStatus.CREATED);
			
		}
		return new ResponseEntity<String>("No loans to add", HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("getLoan/{loanId}")
	private ResponseEntity<GurutuTechLoanEntity> getLoan(@PathVariable Integer loanId)
	{
		if(loanId!= null)
		{
			GurutuTechLoanEntity gte=gts.getLoan(loanId);
			return new ResponseEntity<GurutuTechLoanEntity>(gte, HttpStatus.CREATED);
		}
		return null;
		
	}
	@GetMapping("/getAllLoan")
	private ResponseEntity<List<GurutuTechLoanEntity>> getAllLoan()
	{
		List<GurutuTechLoanEntity> entities=gts.getAllLoan();
		
		return new ResponseEntity<List<GurutuTechLoanEntity>>(entities, HttpStatus.CREATED);
		
	}
	

}
