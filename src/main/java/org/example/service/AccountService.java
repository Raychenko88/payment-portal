package org.example.service;

import org.example.controller.dto.AccountByUserIdResponseDto;
import org.example.controller.dto.AccountCreateDto;
import org.example.model.Account;

import java.util.List;

public interface AccountService {

    Account save(AccountCreateDto accountCreateDto);

    Account update(Account account);

    Account findById(Integer id);

    List<AccountByUserIdResponseDto> findAllByUserId(Integer userId);

    List<Account> findAll();

    void delete(Account account);
}
