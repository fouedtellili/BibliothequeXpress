package com.example.bibliothequexpress.controllers;

import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.User;
import com.example.bibliothequexpress.service.CarteBibliothequeService;
import com.example.bibliothequexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartes-bibliotheque")
public class CarteBibliothequeController {
    @Autowired
    private CarteBibliothequeService carteBibliothequeService;
    private UserService userService;

    @GetMapping
    public List<CarteBibliotheque> getAllCartesBibliotheque() {
        return carteBibliothequeService.getAllCartesBibliotheque();
    }

    @GetMapping("/{id}")
    public CarteBibliotheque getCarteBibliothequeById(@PathVariable Long id) {
        return carteBibliothequeService.getCarteBibliothequeById(id);
    }

    @PostMapping("/assigner/{userId}")
    public CarteBibliotheque assignerCarteBibliotheque(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return carteBibliothequeService.assignerCarteBibliotheque(user);
    }

    @DeleteMapping("/{id}")
    public void retirerCarteBibliotheque(@PathVariable Long id) {
        carteBibliothequeService.retirerCarteBibliotheque(id);
    }
}
