package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.TransactionCreateManyPaymentResponseDto;
import org.example.controller.dto.TransactionCreatePaymentDto;
import org.example.controller.dto.TransactionCreatePaymentResponseDto;
import org.example.dao.TransactionDAO;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.service.AccountService;
import org.example.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDAO transactionDAO;
    private final AccountService accountService;

    @Override
    public TransactionCreatePaymentResponseDto save(TransactionCreatePaymentDto transaction) {
        Transaction transactionNew = new Transaction();
        transactionNew.setSrcAccNum(transaction.getSrcAccNum());
        transactionNew.setDestAccNum(transaction.getDestAccNum());
        transactionNew.setAmount(transaction.getAmount());
        transactionNew.setReason(transaction.getReason());
        TransactionCreatePaymentResponseDto tr = new TransactionCreatePaymentResponseDto();
        tr.setId(transactionDAO.save(makeTransaction(transactionNew)).getId());
        return tr;
    }


    @Override
    public List<TransactionCreateManyPaymentResponseDto> saveManyTransaction(List<TransactionCreatePaymentDto> transactions) {
        Transaction transactionNew;
        List<TransactionCreateManyPaymentResponseDto> transactionsDto = new ArrayList<>();
        if (transactions.size() == 0) {
            try {
                throw new Exception("There are no transactions to save");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (TransactionCreatePaymentDto transaction : transactions) {
            TransactionCreateManyPaymentResponseDto transactionResponseDto = new TransactionCreateManyPaymentResponseDto();
            transactionNew = conversionCreatePaymentDtoToTransaction(transaction);
           transactionNew = transactionDAO.save(makeTransaction(checkStatus(balanceCheck(accountService
                    .findById(transaction.getSrcAccNum()),transactionNew),transactionNew)));
           transactionResponseDto.setId(transactionNew.getId());
           transactionResponseDto.setStatus(transactionNew.getStatus());
           transactionsDto.add(transactionResponseDto);
        }
        return transactionsDto;
    }

    Transaction conversionCreatePaymentDtoToTransaction(TransactionCreatePaymentDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setSrcAccNum(transactionDto.getSrcAccNum());
        transaction.setDestAccNum(transactionDto.getDestAccNum());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setReason(transactionDto.getReason());
        return transaction;
    }

    @Override
    public Transaction findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
            (Integer payerId, Integer recipient, Integer srcAccNum, Integer destAccNum) {
        return null;
    }

    public Transaction checkStatus(Boolean bool, Transaction transaction) {
        String status = "ok";
        if (!bool) {
             status = "error";
            transaction.setStatus(status);
        }
        transaction.setStatus(status);
        return transaction;
    }


    public Boolean transactionsHaveId(Account srcAcc, Account destAcc) {
        if (accountService.findById(srcAcc.getId()) == null || accountService.findById(destAcc.getId()) == null) {
            try {
                throw new Exception("Transaction id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public Boolean balanceCheck(Account srcAcc, Transaction transaction) {
        Boolean check = true;
        if (srcAcc.getBalance().compareTo(transaction.getAmount()) < 0) {
            check = false;
            try {
                throw new Exception("You don't have enough funds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public void makeTransferOfFunds(Account srcAcc, Account destAcc, Transaction transaction) {
        srcAcc.setBalance(srcAcc.getBalance().subtract(transaction.getAmount()));
        destAcc.setBalance(destAcc.getBalance().add(transaction.getAmount()));
        accountService.update(srcAcc);
        accountService.update(destAcc);
        transactionDAO.save(transaction);
    }

    @Override
    public Transaction makeTransaction(Transaction transaction) {
        Account srcAcc = accountService.findById(transaction.getSrcAccNum());
        Account destAcc = accountService.findById(transaction.getDestAccNum());

        if (transactionsHaveId(srcAcc, destAcc) && balanceCheck(srcAcc, transaction)) {
            transaction.setPayer(srcAcc.getUser());
            transaction.setRecipient(destAcc.getUser());
            makeTransferOfFunds(srcAcc, destAcc, transaction);
        }
        return transaction;
    }





    @Override
    public Transaction update(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction findById(Integer id) {
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public void delete(Transaction transaction) {

    }
}
