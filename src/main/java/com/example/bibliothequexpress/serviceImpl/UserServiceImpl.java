package com.example.bibliothequexpress.serviceImpl;

import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.User;
import com.example.bibliothequexpress.repository.CarteBibliothequeRepository;
import com.example.bibliothequexpress.repository.UserRepository;
import com.example.bibliothequexpress.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarteBibliothequeRepository carteBibliothequeRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void assignLibraryCard(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        if (user.getCarteBibliotheque() == null) {
            CarteBibliotheque carte = new CarteBibliotheque();
            carte.setUser(user);
            carteBibliothequeRepository.save(carte);
        } else {
            throw new IllegalStateException("L'utilisateur a déjà une carte de bibliothèque");
        }
    }

    public void deleteCarte(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null && user.getCarteBibliotheque() != null) {

            user.setCarteBibliotheque(null);
            userRepository.save(user);
        }
    }
}

