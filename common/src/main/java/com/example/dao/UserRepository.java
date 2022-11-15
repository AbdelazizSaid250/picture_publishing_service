package com.example.dao;

import com.example.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, UUID> {
}
