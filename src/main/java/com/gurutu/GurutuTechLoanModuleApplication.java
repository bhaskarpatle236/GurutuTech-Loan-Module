package com.gurutu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class GurutuTechLoanModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GurutuTechLoanModuleApplication.class, args);
	}
	
	@Bean
	public RestTemplate rTemplate()
	{
		RestTemplate rs=new RestTemplate();
		return rs;
		
	}

}
