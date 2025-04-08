package com.dbms.loanSanction.main.serviceInterface;

import com.dbms.loanSanction.main.model.SanctionLetter;

import jakarta.validation.Valid;

public interface LoanSanctionServiceI {

 public	SanctionLetter saveSanctionLetter(@Valid SanctionLetter sanctionletter);

}
