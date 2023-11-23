package com.example.bibliothequexpress.repository;


import com.example.bibliothequexpress.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
