package com.example.bibliothequexpress.repository;

import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteBibliothequeRepository extends JpaRepository<CarteBibliotheque, Long> {
}
