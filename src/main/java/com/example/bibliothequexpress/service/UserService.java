package com.example.bibliothequexpress.service;


import com.example.bibliothequexpress.model.User;

import java.util.List;

public interface UserService {
    public User userRegister(User user);
    public void initRolesAndUsers();
    public User registerNewUser(User user);


    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser (User user);
    void assignLibraryCard(Long userId);
     void deleteCarte(Long userId);
}
