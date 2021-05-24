package org.example.service;

import org.example.controller.dto.TransactionDto;
import org.example.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction save(Transaction transaction);

    public List<Transaction> saveManyTransaction(List<Transaction> transactions);

    Transaction findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum(TransactionDto transactionDto);

    Transaction update(Transaction transaction);

    Transaction findById(Integer id);

    List<Transaction> findAll();

    public Transaction makeTransaction(Transaction transaction);

    void delete(Transaction transaction);
}
