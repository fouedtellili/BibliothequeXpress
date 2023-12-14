package com.example.bibliothequexpress.serviceImpl;

import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.User;
import com.example.bibliothequexpress.repository.CarteBibliothequeRepository;
import com.example.bibliothequexpress.repository.UserRepository;
import com.example.bibliothequexpress.service.CarteBibliothequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteBibliothequeServiceImpl implements CarteBibliothequeService {
    @Autowired
    private CarteBibliothequeRepository carteBibliothequeRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<CarteBibliotheque> getAllCartesBibliotheque() {
        return carteBibliothequeRepository.findAll();
    }

    @Override
    public CarteBibliotheque getCarteBibliothequeById(Long id) {
        return carteBibliothequeRepository.findById(id).orElse(null);
    }

    @Override
    public CarteBibliotheque assignerCarteBibliotheque(User user) {
        CarteBibliotheque carte = new CarteBibliotheque();
        carte.setUser(user);
        return carteBibliothequeRepository.save(carte);
    }

    @Override
    public void retirerCarteBibliotheque(Long id) {
        carteBibliothequeRepository.deleteById(id);
    }




}
