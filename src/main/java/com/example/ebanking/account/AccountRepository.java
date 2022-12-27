package com.example.ebanking.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT * FROM account WHERE account_no=?1", nativeQuery = true)
    Account getAccDetailsById(String accountNo);

}
