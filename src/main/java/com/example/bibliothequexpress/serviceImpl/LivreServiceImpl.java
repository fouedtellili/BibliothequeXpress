package com.example.bibliothequexpress.serviceImpl;

import com.example.bibliothequexpress.model.Livre;
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
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
