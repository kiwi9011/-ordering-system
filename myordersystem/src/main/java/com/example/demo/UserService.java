package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 創建新用戶
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 根據用戶名稱查找用戶
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // 根據ID查找用戶
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
