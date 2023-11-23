package com.example.bibliothequexpress.serviceImpl;

import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.repository.LivreRepository;
import com.example.bibliothequexpress.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    private LivreRepository livreRepository;

    @Override
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    @Override
    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return livreRepository.save(livre);
    }
    @Override
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }

    @Override
    public void addExemplaires(Long livreId, int quantite) {
        Livre livre = livreRepository.findById(livreId).orElse(null);
        if (livre != null) {
            livre.setExemplairesDisponibles(livre.getExemplairesDisponibles() + quantite);
            livreRepository.save(livre);
        }

    }
    @Override
    public List<Livre> searchLivres(String titre, String auteur, Long categorieId) {
        if (titre != null && auteur != null && categorieId != null) {
            return livreRepository.findByTitreContainingAndAuteurContainingAndCategorieId(titre, auteur, categorieId);
        } else if (titre != null && auteur != null) {
            return livreRepository.findByTitreContainingAndAuteurContaining(titre, auteur);
        } else if (titre != null) {
            return livreRepository.findByTitreContaining(titre);
        } else if (auteur != null) {
            return livreRepository.findByAuteurContaining(auteur);
        } else if (categorieId != null) {
            return livreRepository.findByCategorieId(categorieId);
        } else {
            return livreRepository.findAll();
        }
    }

}
