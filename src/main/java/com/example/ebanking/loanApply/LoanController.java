package com.example.ebanking.loanApply;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/api/loanApply")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loanDetails/{lId}")
    public Loan loanDetails(@PathVariable long lId) {

        return loanRepository.getLoanDetailsById(lId);
    }

    @CrossOrigin()
    @PostMapping("/applyLoan")
    public StatusL applyLoan(@Valid @RequestBody Loan loan) {

        loanRepository.save(loan);
        return StatusL.LOAN_APPLIED_SUCCESSFULLY_PLEASE_WAIT_FOR_THE_CONFIRMATION;
    }

}
