package com.example.bibliothequexpress.service;

import com.example.bibliothequexpress.model.Categorie;
import java.util.List;
public interface CategorieService {
    List<Categorie> getAllCategories();
    Categorie getCategorieById(Long id);
    Categorie saveCategorie(Categorie categorie);
    void deleteCategorie(Long id);
}
