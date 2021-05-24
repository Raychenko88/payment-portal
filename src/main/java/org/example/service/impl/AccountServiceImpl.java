package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.AccountDAO;
import org.example.model.Account;
import org.example.model.User;
import org.example.service.AccountService;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService {

    private final AccountDAO accountDAO;

    @Override
    public Account save(Account account) {
        if (account.getId() != null) {
            try {
                throw new Exception("User already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return accountDAO.save(account);
    }

    @Override
    public Account update(Account account) {
        if (account.getId() == null) {
            try {
                throw new Exception("User id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return accountDAO.save(account);
    }

    @Override
    public Account findById(Integer id) {
        Optional<Account> user = ofNullable(accountDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return user.get();
    }

    @Override
    public  List<Account> findAllByUserId(Integer userId) {
        return accountDAO.findAllByUserId(userId);
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public void delete(Account account) {
        accountDAO.delete(account);
    }
}
