package com.example.ebanking.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    private String accountNo;
    private String username;
    private String password;
    @Size(max=10)
    private String phoneNo;
    private boolean loggedIn;

}
