package com.example.ebanking.transfer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/transfer")

public class TransferController {

    @Autowired
    private TransferRepository transferRepository;

    @GetMapping("getDetailsById/{tId}")
    public Transfer getDetailsById(@PathVariable String tId){

        return transferRepository.getDetailsById(tId);
    }

    @CrossOrigin()
    @PostMapping("/details")
    public StatusT transferAmount(@Valid @RequestBody Transfer transferAmount) {
        List<Transfer> transfers = transferRepository.findAll();

        for (Transfer transfer : transfers) {
            if (transfer.equals(transferAmount)) {
                log.info("FAILURE");
                return StatusT.FAILURE;
            }
        }

        transferRepository.save(transferAmount);
        return StatusT.AMOUNT_TRANSFERED_SUCCESSFULLY;

    }
}
