package com.example.ebanking.transfer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="transfer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transfer_generator")
    @SequenceGenerator(name="transfer_generator", sequenceName = "transfer_seq", allocationSize=50)
    @Column(name = "tId", updatable = false, nullable = false)
    private long tId;

    private String accountNo;
    private String bankName;
    private double amount;
}
