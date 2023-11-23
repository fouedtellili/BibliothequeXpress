package com.example.bibliothequexpress.repository;

import com.example.bibliothequexpress.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}
