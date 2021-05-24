package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.UserAndAccountDto;
import org.example.dao.AccountDAO;
import org.example.dao.UserDAO;
import org.example.model.Account;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final AccountDAO accountDAO;


    @Override
    public UserAndAccountDto save(UserAndAccountDto userAndAccountDto) {
        if (userAndAccountDto.getId() != null) {
            try {
                throw new Exception("User already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        User user = new User();
        user.setFirstName(userAndAccountDto.getFirstName());
        user.setLastName(userAndAccountDto.getLastName());
         user = userDAO.save(user);
        userAndAccountDto.setId(user.getId());
        if (userAndAccountDto.getAccounts().size() > 0) {
            for (Account ac : userAndAccountDto.getAccounts()) {
                ac.setUser(user);
                accountDAO.save(ac);
            }
        }
        return userAndAccountDto;
    }

    @Override
    public User update(User user) {
        if (user.getId() == null) {
            try {
                throw new Exception("User id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userDAO.save(user);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user = ofNullable(userDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return user.get();
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
