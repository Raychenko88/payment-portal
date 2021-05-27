package org.example.service;

import org.example.controller.dto.UserAndAccountDto;
import org.example.controller.dto.UserAndAccountResponseDto;
import org.example.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    UserAndAccountResponseDto save(UserAndAccountDto userAndAccountDto);

    User update(User user);

    User findById(Integer id);

    List<User> findAll();

//    User findByLogin(String login);

    void delete(User user);
}
