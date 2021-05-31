package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.UserAndAccountDto;
import org.example.controller.dto.UserAndAccountResponseDto;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
        , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserAndAccountResponseDto> save(@RequestBody UserAndAccountDto userAndAccountDto) {
        try {
            return new ResponseEntity<>(userService.save(userAndAccountDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
