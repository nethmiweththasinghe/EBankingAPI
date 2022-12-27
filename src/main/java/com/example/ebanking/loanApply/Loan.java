package com.example.ebanking.loanApply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_generator")
    @SequenceGenerator(name="loan_generator", sequenceName = "loan_seq", allocationSize=50)
    @Column(name = "lId", updatable = false, nullable = false)
    private long lId;
    private String reason;
    private String income;
    private double amount;

}
