package com.example.ebanking.billPayments;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("getDetailsById/{pId}")
    public Payment getDetailsById(@PathVariable String pId){

        return paymentRepository.getDetailsById(pId);
    }

    @CrossOrigin()
    @PostMapping("/addDetails")
    public StatusP paymentAmount(@Valid @RequestBody Payment paymentAmount) {
        List<Payment> payments = paymentRepository.findAll();

        for (Payment payment : payments) {
            if (payment.equals(paymentAmount)) {
                log.info("FAILURE");
                return StatusP.FAILURE;
            }
        }

        paymentRepository.save(paymentAmount);
        return StatusP.PAYMENT_SUCCESS;
    }
}
