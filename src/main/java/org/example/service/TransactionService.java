package org.example.service;

import org.example.controller.dto.TransactionCreateManyPaymentResponseDto;
import org.example.controller.dto.TransactionCreatePaymentDto;
import org.example.controller.dto.TransactionCreatePaymentResponseDto;
import org.example.model.Transaction;

import java.util.List;

public interface TransactionService {

    TransactionCreatePaymentResponseDto save(TransactionCreatePaymentDto transaction);

    public List<TransactionCreateManyPaymentResponseDto> saveManyTransaction(List<TransactionCreatePaymentDto> transactions);

    List<Transaction> findByParameters
            (Integer payerId, Integer recipient, Integer srcAccNum, Integer destAccNum);

    public Transaction makeTransaction(Transaction transaction);
}
