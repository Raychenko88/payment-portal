package org.example.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.example.model.Account;
import org.example.model.User;
import org.example.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List> findAllByUserId(@RequestParam  Integer userId) {
        try {
            return new ResponseEntity<>(accountService.findAllByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
