package com.example.bibliothequexpress.controllers;


import com.example.bibliothequexpress.model.Emprunt;
import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.model.User;
import com.example.bibliothequexpress.service.EmpruntService;
import com.example.bibliothequexpress.service.LivreService;
import com.example.bibliothequexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private UserService userService;

    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Emprunt> getAllEmprunts() {
        return empruntService.getAllEmprunts();
    }

    @GetMapping("/{id}")
    public Emprunt getEmpruntById(@PathVariable Long id) {
        return empruntService.getEmpruntById(id);
    }

    @PostMapping("/emprunter/{utilisateurId}/{livreId}")
    public Emprunt emprunterLivre(@PathVariable Long utilisateurId, @PathVariable Long livreId) {
        User user = userService.getUserById(utilisateurId);
        Livre livre = livreService.getLivreById(livreId);
        return empruntService.emprunterLivre(user, livre);
    }

    @PostMapping("/retourner/{empruntId}")
    public void retournerLivre(@PathVariable Long empruntId) {
        empruntService.retournerLivre(empruntId);
    }

    @PostMapping("/renouveler/{empruntId}")
    public void renouvelerEmprunt(@PathVariable Long empruntId) {
        empruntService.renouvelerEmprunt(empruntId);
    }
}
