package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.TransactionDto;
import org.example.dao.TransactionDAO;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.service.AccountService;
import org.example.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDAO transactionDAO;
    private final AccountService accountService;

    @Override
    public Transaction save(Transaction transaction) {
        if (transaction.getId() != null) {
            try {
                throw new Exception("Transaction already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return transactionDAO.save(makeTransaction(transaction));
    }


    @Override
    public List<Transaction> saveManyTransaction(List<Transaction> transactions) {
        String status = "status : error";
        if (transactions.size() == 0) {
            try {
                throw new Exception("There are no transactions to save");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Transaction transaction : transactions) {
            transactionDAO.save(makeTransaction(checkStatus(balanceCheck(accountService
                    .findById(transaction.getSrcAccNum()),transaction),transaction)));
        }
        return transactions;
    }

    @Override
    public Transaction findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
            (TransactionDto transactionDto) {
        return transactionDAO.findByPayerIdAndRecipientIdAndSrcAccNumAndDestAccNum
                (transactionDto.getPayer().getId(), transactionDto.getRecipient().getId()
                        , transactionDto.getSrcAccNum(), transactionDto.getDestAccNum());
    }

    public Transaction checkStatus(Boolean bool, Transaction transaction) {
        String status = "\nstatus : ok";
        if (!bool) {
             status = "\nstatus : error";
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
        if (srcAcc.getBalance().compareTo(transaction.getAmount()) < 0) {
            try {
                throw new Exception("You don't have enough funds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
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
