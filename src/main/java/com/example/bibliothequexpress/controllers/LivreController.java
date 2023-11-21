package com.example.bibliothequexpress.controllers;

import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
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
}

