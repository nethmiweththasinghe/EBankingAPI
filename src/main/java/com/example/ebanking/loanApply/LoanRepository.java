package com.example.ebanking.loanApply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query(value = "SELECT * FROM loan WHERE l_id=?1", nativeQuery = true)
    Loan getLoanDetailsById(Long lId);
}
