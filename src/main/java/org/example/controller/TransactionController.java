package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.TransactionCreatePaymentDto;
import org.example.controller.dto.TransactionCreatePaymentResponseDto;
import org.example.model.Transaction;
import org.example.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "transaction", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
        , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionCreatePaymentResponseDto> save
            (@RequestBody TransactionCreatePaymentDto transactionCreatePaymentDto) {
        try {
            return new ResponseEntity<>(transactionService.save(transactionCreatePaymentDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "transactions")
    public ResponseEntity<List> saveManyTransaction(@RequestBody List<TransactionCreatePaymentDto> list) {
        try {
            return new ResponseEntity<>(transactionService.saveManyTransaction(list), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<List> findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
            (@RequestParam(value = "payer_id", required=false) Integer payerId,
             @RequestParam(value = "recipient_id", required=false) Integer recipientId,
             @RequestParam(value = "source_acc_id", required=false) Integer srcAccNum,
             @RequestParam(value = "dest_acc_id", required=false) Integer destAccNum) {
            return new ResponseEntity<>(transactionService.findByParameters
                    (payerId, recipientId, srcAccNum, destAccNum), HttpStatus.OK);
    }
}
