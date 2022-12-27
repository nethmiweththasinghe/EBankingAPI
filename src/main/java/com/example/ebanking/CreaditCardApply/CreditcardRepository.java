package com.example.ebanking.CreaditCardApply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreditcardRepository extends JpaRepository<creditcard, String> {

    @Query(value = "SELECT * FROM creditcard WHERE ApplicationID=?1", nativeQuery = true)
    creditcard getAccDetailsById(String ApplicationID);

    //@Modifying
    //@Query(value = "UPDATE * FROM creditcard WHERE ApplicationID=?1", nativeQuery = true)
    //creditcard updateUsers(String ApplicationID);

}