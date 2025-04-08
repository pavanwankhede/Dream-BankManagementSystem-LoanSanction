package com.dbms.loanSanction.main.model;

import java.util.Date;

import com.dbms.loanSanction.main.enums.SanctionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sanctionletterTable")
@Entity
public class SanctionLetter {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int sanctionId;
        
	   private String applicantName;

	    private long contactDetails;

	    private String productOnRoadPrice;

	    private double loanAmountSanctioned;

	    private String interestType;

	    private float rateOfInterest;

	    private int loanTenureInMonths;

	    private double monthlyEmiAmount;

	    private String modeOfPayment;

	    private String remarks;

	    private String termsAndConditions;

	    private SanctionStatus sanctionStatus; // CREATED, OFFERED, ACCEPTED, REJECTED
	    
	    @Temporal(TemporalType.TIMESTAMP)
		 private Date sanctionDate;

	    private int loanApplicationId; // Same as loanApplicationVerification module

	    // private byte[] sanctionLetter;
	    
		/*
		 * @PrePersist protected void onCreate() { this.sanctionDate = new Date(); }
		 */
}
