package org.example.dao;

import org.example.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

    @Query (value = "SELECT t.times_tamp, t.src_acc_num, t.dest_acc_num, t.amount, t.payer_id, t.recipient_id " +
            " FROM transactions t" +
            " WHERE (:payerId is null or t.payer_id = :payerId) and (:recipientId is null"
            + " or t.recipient_id = :recipientId) and (:srcAccNumId is null"
            + " or t.src_acc_num = :recipientId) and (:destAccNumId is null"
            + " or t.dest_acc_num = :destAccNumId)", nativeQuery = true)
    List<Transaction> findAllByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
            (@Param("payerId") Integer payerId, @Param("recipientId") Integer recipientId,
             @Param("srcAccNumId") Integer srcAccNumId, @Param("destAccNumId") Integer destAccNumId);
}
