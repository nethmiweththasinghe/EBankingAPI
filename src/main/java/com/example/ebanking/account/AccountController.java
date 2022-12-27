package com.example.ebanking.account;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("getAccDetailsById/{accountNo}")
    public Account getAccDetailsById(@PathVariable String accountNo){

        return accountRepository.getAccDetailsById(accountNo);
    }

    @CrossOrigin()
    @PostMapping("/addAccDetails")
    public Account addAccDetails(@RequestBody Account account) {

        return accountRepository.save(account);

    }
}
