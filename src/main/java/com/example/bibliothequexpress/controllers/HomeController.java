package com.example.bibliothequexpress.controllers;


import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.service.CatalogService;
import com.example.bibliothequexpress.service.LivreService;
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


    @GetMapping("/home")
    public String home(Model model) {
        List<Livre> catalogItems = catalogService.getAllLivres();
        model.addAttribute("catalogItems", catalogItems);
        return "home";
    }


}
