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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
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

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE
//            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<User> update(@RequestBody User user) {
//        try {
//            return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//    @GetMapping(path = "/{id}")
//    public ResponseEntity<User> findById(@PathVariable Integer id) {
//        try {
//            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//
//    @GetMapping
//    public ResponseEntity<List> findAll() {
//        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//    }
//
//
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity delete(@PathVariable Integer id) {
//        try {
//            userService.delete(userService.findById(id));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
