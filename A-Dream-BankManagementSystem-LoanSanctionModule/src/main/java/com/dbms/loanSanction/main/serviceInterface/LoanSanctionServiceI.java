package com.dbms.loanSanction.main.serviceInterface;

import java.util.List;

import com.dbms.loanSanction.main.model.SanctionLetter;

import jakarta.validation.Valid;

public interface LoanSanctionServiceI {

 public	SanctionLetter saveSanctionLetter(@Valid SanctionLetter sanctionletter);

public List<SanctionLetter> getAllSanctionLetters();

}
