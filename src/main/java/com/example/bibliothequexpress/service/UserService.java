package com.example.bibliothequexpress.service;


import com.example.bibliothequexpress.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser (User user);
}
