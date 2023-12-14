package com.example.bibliothequexpress.serviceImpl;


import com.example.bibliothequexpress.model.Livre;
import com.example.bibliothequexpress.repository.LivreRepository;
import com.example.bibliothequexpress.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }



}
