package com.example.ebanking.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private String accountNo;
    private String branchName;
    private String NIC;
    private String Name;
    private String accountType;
    private double accountBal = 0;
}
