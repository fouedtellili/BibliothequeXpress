package com.example.bibliothequexpress.service;


import com.example.bibliothequexpress.model.Livre;

import java.util.List;

public interface LivreService {
    List<Livre> getAllLivres();
    Livre getLivreById(Long id);
    Livre saveLivre(Livre livre);
    void deleteLivre(Long id);
}
