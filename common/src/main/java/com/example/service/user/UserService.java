package com.example.service.user;

import com.example.model.dto.AuthDto;

public interface UserService {

    void saveOrUpdate(AuthDto.SignUpDto signUpDto);
}
