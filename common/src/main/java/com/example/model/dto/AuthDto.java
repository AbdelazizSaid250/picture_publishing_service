package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;

public class AuthDto {

    // Private Constructor to prevent creating new instant from this class
    private AuthDto() {
    }

    /**
     * A DTO for the {@link com.example.model.entity.User} entity
     */
    @Data
    public static class SignUpDto implements Serializable {
        private final String name;
        private final String email;
        private final String password;
    }

    /**
     * A DTO for the {@link com.example.model.entity.User} entity
     */
    @Data
    public static class LoginDto implements Serializable {
        private final String email;
        private final String password;
    }


}
