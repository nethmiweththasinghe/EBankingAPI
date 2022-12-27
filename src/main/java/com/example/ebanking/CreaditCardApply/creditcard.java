package com.example.ebanking.CreaditCardApply;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="creditcard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class creditcard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "creditcard_generator")
    @SequenceGenerator(name="creditcard_generator", sequenceName = "creditcard_seq", allocationSize=50)
    @Column(name = "ApplicationID", updatable = false, nullable = false)
    public long ApplicationID;

    private String FullName;
    @Size(max = 100)
    private String phoneNo;
    private String Address;
    private String Job;
    private String gender;
    private int monthly_salary;

}

