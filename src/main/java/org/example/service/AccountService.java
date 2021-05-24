package org.example.service;

import io.swagger.models.auth.In;
import org.example.model.Account;
import org.example.model.User;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    Account update(Account account);

    Account findById(Integer id);

    List<Account> findAllByUserId(Integer userId);

    List<Account> findAll();

    void delete(Account account);
}
