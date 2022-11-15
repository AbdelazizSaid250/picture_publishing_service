package com.example.service.user;

import com.example.dao.UserRepository;
import com.example.model.dto.AuthDto;
import com.example.model.entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        log.info("I am in UserServiceImpl Constructor!!");
        this.userRepository = userRepository;
    }

    @Override
    public void saveOrUpdate(AuthDto.SignUpDto signUpDto) {

        // encrypt the password.
        /// Note: It's better to put the encrypted password in a different database for security reasons.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpDto.getPassword());

        User savedUser = new User(UUID.randomUUID());
        savedUser.setName(signUpDto.getName());
        savedUser.setEmail(signUpDto.getEmail());
        savedUser.setPassword(encodedPassword);

        userRepository.save(savedUser);

        log.info("Successfully saved the user: {}" + savedUser);
    }
}
