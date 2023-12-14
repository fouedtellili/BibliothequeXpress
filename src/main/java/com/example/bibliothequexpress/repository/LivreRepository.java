package com.example.bibliothequexpress.repository;

import com.example.bibliothequexpress.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> { List<Livre> findByTitreContainingAndAuteurContainingAndCategorieId(String titre, String auteur, Long categorieId);
    List<Livre> findByTitreContainingAndAuteurContaining(String titre, String auteur);
    List<Livre> findByTitreContaining(String titre);
    List<Livre> findByAuteurContaining(String auteur);
    List<Livre> findByCategorieId(Long categorieId);


}
