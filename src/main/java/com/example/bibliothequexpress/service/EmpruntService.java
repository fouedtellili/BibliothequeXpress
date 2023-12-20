package com.example.bibliothequexpress.service;


import com.example.bibliothequexpress.model.Emprunt;
import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.model.User;

import java.util.List;

public interface EmpruntService {
    List<Emprunt> getAllEmprunts();
    Emprunt getEmpruntById(Long id);
    Emprunt emprunterLivre(User user, Livre livre);
    void retournerLivre(Long empruntId);
    void renouvelerEmprunt(Long empruntId);

}
