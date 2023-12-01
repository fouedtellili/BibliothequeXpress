package com.example.bibliothequexpress.controllers;

import com.example.bibliothequexpress.model.Categorie;
import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.service.CategorieService;
import com.example.bibliothequexpress.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        List<Livre> books = livreService.getAllLivres();
        model.addAttribute("books", books);
        return "home";
    }
    @GetMapping
    public List<Livre> getAllLivres() {


            List<Livre> userList = livreService.getAllLivres();
            return userList;
    }
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        List<Livre> book = livreService.getAllLivres();
        model.addAttribute("book", book);
        return "books";
    }
    @GetMapping("/books/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        Livre book = livreService.getLivreById(id);
        model.addAttribute("book", book);
        return "book-details";
    }
    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        model.addAttribute("newBook", new Livre());
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Livre newBook) {
        livreService.saveLivre(newBook);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }



    @PostMapping
    public Livre saveLivre(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    @DeleteMapping("books/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }

    @GetMapping("/books/update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        List<Categorie> categories = categorieService.getAllCategories(); // Obtenez la liste des catégories
        model.addAttribute("categories", categories);
        Livre book = livreService.getLivreById(id);
        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Livre updatedBook) {
        Livre existingBook = livreService.getLivreById(id);

        existingBook.setTitre(updatedBook.getTitre());
        existingBook.setAuteur(updatedBook.getAuteur());
        existingBook.setDatePublication(updatedBook.getDatePublication());
        existingBook.setNumeroISBN(updatedBook.getNumeroISBN());
        existingBook.setExemplairesDisponibles(updatedBook.getExemplairesDisponibles());
        existingBook.setCategorie(updatedBook.getCategorie());

        livreService.saveLivre(existingBook);
        return "redirect:/books";
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

