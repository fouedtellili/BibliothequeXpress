package com.example.bibliothequexpress.controllers;

import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.Categorie;
import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.model.User;
import com.example.bibliothequexpress.service.CarteBibliothequeService;
import com.example.bibliothequexpress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarteBibliothequeService carteBibliothequeService;



    @PostMapping("/{userId}/assign-library-card")
    public ResponseEntity<String> assignLibraryCard(@PathVariable Long userId) {
        try {
            userService.assignLibraryCard(userId);
            return ResponseEntity.ok("Carte attribuée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'attribution de la carte : " + e.getMessage());
        }
    }
    @PostMapping("/delete-carte")
    public String deleteCarte(@RequestParam Long userId) {
        try {
            userService.deleteCarte(userId);
            return "redirect:/users";
        } catch (Exception e) {
            return "redirect:/users";
        }
    }


    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("newUser", new User());
        return "add-user";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute User updatedUser) {
        User existingUser = userService.getUserById(id);

        existingUser.setAdresse(updatedUser.getAdresse());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setNom(updatedUser.getNom());
        existingUser.setPrenom(updatedUser.getPrenom());
        existingUser.setPassword(updatedUser.getPassword());


        userService.saveUser(existingUser);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUserDetails(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";
    }


    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PutMapping("/update-user")
    public User updateUser(@RequestBody User u) {
        User user= userService.updateUser(u);
        return user;
    }
}
