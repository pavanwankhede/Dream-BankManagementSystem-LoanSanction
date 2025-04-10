package com.dbms.loanSanction.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.loanSanction.main.enums.SanctionStatus;
import com.dbms.loanSanction.main.model.SanctionLetter;
import com.dbms.loanSanction.main.serviceInterface.LoanSanctionServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loansanction")
public class LoanSanctionController {
         
	     @Autowired
	    private LoanSanctionServiceI sanctionServiceI;
	     
	       
	 	private static final Logger log= LoggerFactory.getLogger(LoanSanctionController.class);
		
    @PostMapping("/addSactionLetter")		
   public ResponseEntity<SanctionLetter> saveSanctionLetter(@Valid @RequestBody SanctionLetter sanctionletter )
       {
			
	       log.info("Received request to save enquiries: {}", sanctionletter);
		
	       SanctionLetter letter = sanctionServiceI.saveSanctionLetter(sanctionletter);
	return new ResponseEntity<>(letter, HttpStatus.CREATED);
	
		}
		
		@GetMapping("/getAllSanctionLetters")
		public ResponseEntity<List<SanctionLetter>>  getAllEnquiry()
		{
			
			List<SanctionLetter> listLetters=sanctionServiceI.getAllSanctionLetters();
			return new ResponseEntity<List<SanctionLetter>>(listLetters,HttpStatus.OK);
			
		}
		
		
		@GetMapping("/getById/{sanctionId}")
		public ResponseEntity<SanctionLetter> getEnquiryByID(@PathVariable("sanctionId") int id){
			
			SanctionLetter sanctionLetterDetails= sanctionServiceI.getSanctionLetterById(id);
			return new ResponseEntity<SanctionLetter>(sanctionLetterDetails,HttpStatus.OK);
		}
		

		@GetMapping("/getBySanctionStatus/{sanctionStatus}")
		public ResponseEntity<List<SanctionLetter>> getByStatus(@PathVariable("sanctionStatus") SanctionStatus sanctionstatus){
			List<SanctionLetter> sanctionLetter= sanctionServiceI.getBySanctionStatus(sanctionstatus);
			return new ResponseEntity<List<SanctionLetter>>(sanctionLetter,HttpStatus.OK);
		
		}
		@PutMapping("/updateSanctionLetter/{sanctionId}")
		public ResponseEntity<SanctionLetter> updateById(@PathVariable ("sanctionId") int sanctionId,@RequestBody SanctionLetter sanctionletter)
		{
			 log.info("Received request to update SanctionLetter with Sanction Id: {}",sanctionId);
			 SanctionLetter letter=sanctionServiceI.updateSanctionById(sanctionId,sanctionletter);
			 log.info("Successfully updated Sanction Letter with ID: {}", sanctionId);
			return new  ResponseEntity<SanctionLetter>(letter,HttpStatus.OK);
			
		}

		@DeleteMapping("/deleteById/{sanctionId}")
		public ResponseEntity<String> deleteSanctionById(@PathVariable("sanctionId") int id) {
		    sanctionServiceI.deleteSanctionLetterById(id);
		    return new ResponseEntity<>("Sanction letter deleted successfully", HttpStatus.OK);
		}
}
