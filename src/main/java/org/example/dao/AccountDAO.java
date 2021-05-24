package org.example.dao;

import org.example.model.Account;
import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, Integer> {

    List<Account> findAllByUserId(Integer userId);
}
