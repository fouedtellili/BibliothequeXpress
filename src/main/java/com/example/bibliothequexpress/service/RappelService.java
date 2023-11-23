package com.example.bibliothequexpress.service;

import com.example.bibliothequexpress.model.Emprunt;
import com.example.bibliothequexpress.model.Rappel;

import java.util.List;

public interface RappelService {
    List<Rappel> getAllRappels();
    Rappel getRappelById(Long id);
    void genererRappelRetard(Emprunt emprunt);
}
