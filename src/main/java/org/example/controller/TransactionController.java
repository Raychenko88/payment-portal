package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.TransactionDto;
import org.example.model.Transaction;
import org.example.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PutMapping
    public ResponseEntity<String> save(@RequestBody Transaction transaction) {
        try {
            return new ResponseEntity<>(transactionService.save(transaction).toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(value = "transactions")
    public ResponseEntity<String> saveManyTransaction(@RequestBody List<Transaction> list) {
        try {
            return new ResponseEntity<>(transactionService.saveManyTransaction(list).toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping
    public ResponseEntity<Transaction> findAllByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
            (@RequestBody TransactionDto transactionDto) {
        try {
            return new ResponseEntity<>(transactionService.findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
                    (transactionDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
