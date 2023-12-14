package com.example.bibliothequexpress.service;

import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.User;

import java.util.List;

public interface CarteBibliothequeService {
    List<CarteBibliotheque> getAllCartesBibliotheque();
    CarteBibliotheque getCarteBibliothequeById(Long id);
    CarteBibliotheque assignerCarteBibliotheque(User user);
    void retirerCarteBibliotheque(Long id);




}
