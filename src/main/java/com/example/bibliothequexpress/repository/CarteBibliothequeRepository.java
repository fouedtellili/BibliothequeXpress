package com.example.bibliothequexpress.repository;

import com.example.bibliothequexpress.model.CarteBibliotheque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteBibliothequeRepository extends JpaRepository<CarteBibliotheque, Long> {
}
