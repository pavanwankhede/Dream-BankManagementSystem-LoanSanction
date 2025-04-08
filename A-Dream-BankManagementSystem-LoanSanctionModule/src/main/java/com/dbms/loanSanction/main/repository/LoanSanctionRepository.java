package com.dbms.loanSanction.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbms.loanSanction.main.model.SanctionLetter;

@Repository
public interface LoanSanctionRepository extends JpaRepository<SanctionLetter, Integer>{

}
