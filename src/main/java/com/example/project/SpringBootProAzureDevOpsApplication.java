package com.example.project;

import com.example.project.entities.Case;
import com.example.project.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
public class SpringBootProAzureDevOpsApplication implements CommandLineRunner {

	@Autowired
	private CaseRepository caseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProAzureDevOpsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		caseRepository.save(new Case("firstCase", "CaseDescription1"));
		caseRepository.save(new Case("secondCase", "CaseDescription2"));
		caseRepository.save(new Case("thirdCase", "CaseDescription3"));
		caseRepository.save(new Case("fourthCase", "CaseDescription4"));
		caseRepository.save(new Case("fifthCase", "CaseDescription5"));
		caseRepository.save(new Case("sixthCase", "CaseDescription6"));
		caseRepository.save(new Case("seventhCase", "CaseDescription7"));
		caseRepository.save(new Case("eighthCase", "CaseDescription8"));
		caseRepository.save(new Case("ninthCase", "CaseDescription9"));
		caseRepository.save(new Case("tenthCase", "CaseDescription10"));
		List<Case> cases = caseRepository.findAll();
		cases.forEach(c -> {
			System.out.println(c.toString());
			System.out.println("********************");
		});
	}
}
