package org.example.dao;

import org.example.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

//    findAllByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum

    Transaction findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
            (Integer payerId, Integer recipientId, Integer srcAccNumId, Integer destAccNumId);
}
