package com.example.bibliothequexpress.controllers;


import com.example.bibliothequexpress.model.Categorie;
import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.service.CatalogService;
import com.example.bibliothequexpress.service.CategorieService;
import com.example.bibliothequexpress.service.LivreService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    CategorieService categorieService;


    @GetMapping("/home")
    public String home(Model model) {
        List<Livre> catalogItems = catalogService.getAllLivres();
        List<Categorie> categories = categorieService.getAllCategories();
        model.addAttribute("catalogItems", catalogItems);
        model.addAttribute("categories", categories);
        return "home";
    }


}
