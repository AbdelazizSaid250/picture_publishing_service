package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.model.entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
}