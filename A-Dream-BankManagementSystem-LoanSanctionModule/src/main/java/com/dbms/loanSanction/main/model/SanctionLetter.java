package com.dbms.loanSanction.main.model;

import java.util.Date;

import com.dbms.loanSanction.main.enums.SanctionStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Applicant name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 to 100 characters")
    private String applicantName;

    @NotNull(message = "Contact details are required")
    @Digits(integer = 10, fraction = 0, message = "Contact number should be 10 digits")
    private long contactDetails;

    @NotBlank(message = "Product On Road Price is required")
    private String productOnRoadPrice;

    @Positive(message = "Loan amount must be greater than zero")
    private double loanAmountSanctioned;

    @NotBlank(message = "Interest type is required")
    private String interestType;

    @DecimalMin(value = "0.1", message = "Rate of interest must be at least 0.1")
    @DecimalMax(value = "50.0", message = "Rate of interest must be below 50.0")
    private float rateOfInterest;

    @Min(value = 1, message = "Loan tenure must be at least 1 month")
    private int loanTenureInMonths;

    @Positive(message = "Monthly EMI must be greater than zero")
    private double monthlyEmiAmount;

    @NotBlank(message = "Mode of payment is required")
    private String modeOfPayment;

    @Size(max = 500, message = "Remarks can be up to 500 characters")
    private String remarks;

    @Size(max = 1000, message = "Terms and conditions can be up to 1000 characters")
    private String termsAndConditions;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Sanction status is required")
    private SanctionStatus sanctionStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sanctionDate;

    @Min(value = 1, message = "Loan Application ID must be valid")
    private int loanApplicationId;

    // Uncomment if needed
    // private byte[] sanctionLetter;

}
