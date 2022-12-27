package com.example.ebanking.billPayments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
    @SequenceGenerator(name="payment_generator", sequenceName = "payment_seq", allocationSize=50)
    @Column(name = "pId", updatable = false, nullable = false)
    private long pId;

    private String accountNo;
    @Size(max = 10)
    private String phoneNo;
    private double amount;
}
