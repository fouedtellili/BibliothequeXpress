package com.example.bibliothequexpress.serviceImpl;


import com.example.bibliothequexpress.model.CarteBibliotheque;
import com.example.bibliothequexpress.model.Role;
import com.example.bibliothequexpress.model.User;
import com.example.bibliothequexpress.repository.CarteBibliothequeRepository;
import com.example.bibliothequexpress.repository.RoleRepository;
import com.example.bibliothequexpress.repository.UserRepository;
import com.example.bibliothequexpress.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarteBibliothequeRepository carteBibliothequeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User userRegister(User user){
        Role role=roleRepository.findById("User").get();
        user.getRole().add(role);
        return userRepository.save(user);
    }
    @Override
    public void initRolesAndUsers(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleRepository.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role");
        roleRepository.save(userRole);

        User adminUser=new User();
        adminUser.setNom("Admin1");
        adminUser.setPrenom("Admin");
        adminUser.setEmail("Admin@gmail.com");
        adminUser.setPassword("admin@123");
        adminUser.getRole().add(adminRole);
        userRepository.save(adminUser);
        User user=new User();
        user.setNom("user1");
        user.setPrenom("user");
        user.setEmail("user@gmail.com");
        user.setPassword("user@123");
        user.getRole().add(userRole);
        userRepository.save(user);
    }


    @Override
    public User registerNewUser(User user) {
        Role role = roleRepository.findById("User").get();


        user.getRole().add(role);
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }
    private Role checkRoleExist() {
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
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

