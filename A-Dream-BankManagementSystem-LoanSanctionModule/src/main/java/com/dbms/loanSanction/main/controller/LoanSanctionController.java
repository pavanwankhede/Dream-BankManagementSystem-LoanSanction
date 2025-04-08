package com.dbms.loanSanction.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		public ResponseEntity<SanctionLetter> saveSanctionLetter(@Valid @RequestBody SanctionLetter sanctionletter ){
			
		
	         log.info("Received request to save enquiries: {}", sanctionletter);
		
	         SanctionLetter letter = sanctionServiceI.saveSanctionLetter(sanctionletter);
			return new ResponseEntity<>(letter, HttpStatus.CREATED);
		}
		
}
