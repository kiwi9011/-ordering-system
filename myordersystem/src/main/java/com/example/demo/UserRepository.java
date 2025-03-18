package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 根據 username 查找 User
    User findByUsername(String username);

    // 根據 id 查找 User，返回 Optional<User>
    @SuppressWarnings("null")
    Optional<User> findById(Long id);
}

