package com.dbms.loanSanction.main.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.loanSanction.main.enums.SanctionStatus;
import com.dbms.loanSanction.main.exceptions.SanctionLetterCreationException;
import com.dbms.loanSanction.main.exceptions.SanctionLetterNotFoundException;
import com.dbms.loanSanction.main.model.SanctionLetter;
import com.dbms.loanSanction.main.repository.LoanSanctionRepository;
import com.dbms.loanSanction.main.serviceInterface.LoanSanctionServiceI;

import jakarta.validation.Valid;


@Service
public class LoanSanctionServiceImpl implements LoanSanctionServiceI{
	
	
	   private static final Logger log = LoggerFactory.getLogger(LoanSanctionServiceImpl.class);
	
	@Autowired
	private LoanSanctionRepository sanctionRepository;

	@Override
	public SanctionLetter saveSanctionLetter(@Valid SanctionLetter sanctionletter) {
		
		  try {
	            log.info("Attempting to save sanction letter for applicant: {}", sanctionletter.getApplicantName());

	            // Auto-set sanctionDate to current system date/time
	         sanctionletter.setSanctionDate(new Date());

	            SanctionLetter savedLetter = sanctionRepository.save(sanctionletter);
	            
	            log.info("Sanction letter saved successfully with ID: {}", savedLetter.getSanctionId());
	            
	            return savedLetter;

	        } catch (Exception e) {
	            log.error("Failed to save sanction letter for applicant: {}", sanctionletter.getApplicantName(), e);
	            throw new SanctionLetterCreationException("Failed to save sanction letter. Please try again.");
	        }
	    }

	@Override
	public List<SanctionLetter> getAllSanctionLetters() {
		 
		return sanctionRepository.findAll();
	}

	@Override
	public SanctionLetter getSanctionLetterById(int id) {
		
Optional<SanctionLetter> sanctionLetter=sanctionRepository.findById(id);
		
		if (sanctionLetter.isEmpty()) {
			
		throw new SanctionLetterNotFoundException("SanctionLetter for sanctionId- "+id+" Is not Found");
		}
		
		return sanctionLetter.get() ;
	}

	@Override
	public List<SanctionLetter> getBySanctionStatus(SanctionStatus sanctionstatus) {
		
		return sanctionRepository.findBySanctionStatus(sanctionstatus);
	}

}
