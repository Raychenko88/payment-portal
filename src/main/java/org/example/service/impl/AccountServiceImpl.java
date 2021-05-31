package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.AccountByUserIdResponseDto;
import org.example.controller.dto.AccountCreateDto;
import org.example.dao.AccountDAO;
import org.example.model.Account;
import org.example.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService {

    private final AccountDAO accountDAO;

    @Override
    public Account save(AccountCreateDto accountCreateDto) {
        Account account = new Account();
        account.setAccountNum(accountCreateDto.getAccountNum());
        account.setAccountType(accountCreateDto.getAccountType());
        account.setBalance(accountCreateDto.getBalance());
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
    public  List<AccountByUserIdResponseDto> findAllByUserId(Integer userId) {
        List<AccountByUserIdResponseDto> listDto = new ArrayList<>();
        List<Account> listAc = accountDAO.findAllByUserId(userId);
        for (Account ac : listAc) {
            AccountByUserIdResponseDto dto = new AccountByUserIdResponseDto();
            dto.setId(ac.getId());
            dto.setAccountNum(ac.getAccountNum());
            dto.setAccountType(ac.getAccountType());
            dto.setBalance(ac.getBalance());
            listDto.add(dto);
        }
        return listDto;
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
