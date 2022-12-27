package com.example.ebanking.CreaditCardApply;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Log4j2
@RestController
@RequestMapping("/api/Creditcard")
public class creditcardcontroller {

    @Autowired
    private CreditcardRepository creditcardRepository;

    @CrossOrigin()
    @GetMapping("getApplicationDetailsById/{ApplicationID}")
    public creditcard getApplicationDetailsById(@PathVariable long ApplicationID){

        return creditcardRepository.getAccDetailsById(String.valueOf(ApplicationID));
    }

    @CrossOrigin()
    @PostMapping("GetApplicant")
    public Status Checkillegibility(@Valid @RequestBody creditcard newapplicant){

        List<creditcard> Applicant = creditcardRepository.findAll();

        for (creditcard newUser : Applicant) {
            if (Applicant.equals(newUser)) {
                log.info("User Already exists!");
                return Status.YOU_HAVE_APPLIED_BEFORE;
            }
        }

        creditcardRepository.save(newapplicant);
        return Status.SUCCESS;
    }

    @CrossOrigin()
    @GetMapping ("Checkillegibility")
    public Status Checkillegibility(@Valid @RequestBody  int sal){

        if(sal > 50000){
            return Status.YOU_CAN_HAVE_A_CREDITCARD_PLEASE_INSERT_YOUR_RECORDS;
        }
        else
            return Status.YOU_CANNOT_HAVE_A_CREDITCARD;
    }

    @CrossOrigin
    @PutMapping("/update/{ApplicationID}")
    public Status updateUsers(@Valid @RequestBody creditcard creditcard){

        creditcardRepository.save(creditcard);
        return Status.SUCCESS;
    }
    @CrossOrigin()
    @DeleteMapping ("deleteApplicantById/{ApplicationID}")
    public void deleteUserById(@PathVariable Long ApplicationID){

        creditcardRepository.deleteById(String.valueOf(ApplicationID));

    }



}
