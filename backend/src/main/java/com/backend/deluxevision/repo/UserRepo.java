package com.backend.deluxevision.repo;

import com.backend.deluxevision.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    public Optional<User> getUserByUserName(String userName);

    void deleteUserByUserName(String userName);
}
