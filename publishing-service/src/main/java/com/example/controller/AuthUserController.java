package com.example.controller;

import com.example.model.dto.AuthDto;
import com.example.service.user.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController("auth_user")
public class AuthUserController {

    private final UserService userService;

    @Autowired
    public AuthUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    void signUp(@RequestBody AuthDto.SignUpDto signUpDto) {
        userService.saveOrUpdate(signUpDto);
        log.info("Successfully Registered the current user.");
    }

    @GetMapping("logout")
    String welcome() {
        return "<h1>Successfully Logged Out</h1>";
    }
}
