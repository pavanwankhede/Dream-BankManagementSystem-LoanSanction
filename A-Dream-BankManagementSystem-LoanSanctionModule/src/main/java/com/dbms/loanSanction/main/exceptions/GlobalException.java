package com.dbms.loanSanction.main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dbms.loanSanction.main.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(SanctionLetterCreationException.class)
	public ResponseEntity<ErrorResponseDTO> handleException(SanctionLetterCreationException e) {
	    ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
	    ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
