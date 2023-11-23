package com.example.bibliothequexpress.controllers;

import com.example.bibliothequexpress.model.Categorie;
import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.service.CategorieService;
import com.example.bibliothequexpress.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Livre> getAllLivres() {


            List<Livre> userList = livreService.getAllLivres();
            return userList;
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    @PostMapping
    public Livre saveLivre(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }
    @PutMapping("/update-livre")
    public Livre updateUser(@RequestBody Livre livre) {
        Livre livre1= livreService.updateLivre(livre);
        return livre1;
    }

    @PostMapping("/{id}/addExemplaires")
    public void addExemplaires(@PathVariable Long id, @RequestParam int quantite) {
        livreService.addExemplaires(id, quantite);
    }

    @GetMapping("/search/{categorieId}")
    public List<Livre> searchLivres(@PathVariable(required = false) String titre,
                                    @PathVariable(required = false) String auteur,
                                    @PathVariable(required = false) Long categorieId) {
        return livreService.searchLivres(titre, auteur, categorieId);
    }


    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

}

