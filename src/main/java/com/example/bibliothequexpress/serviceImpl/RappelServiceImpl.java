package com.example.bibliothequexpress.serviceImpl;

import com.example.bibliothequexpress.model.Emprunt;
import com.example.bibliothequexpress.model.Rappel;
import com.example.bibliothequexpress.repository.RappelRepository;
import com.example.bibliothequexpress.service.RappelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RappelServiceImpl implements RappelService {
    @Autowired
    private RappelRepository rappelRepository;

    @Override
    public List<Rappel> getAllRappels() {
        return rappelRepository.findAll();
    }

    @Override
    public Rappel getRappelById(Long id) {
        return rappelRepository.findById(id).orElse(null);
    }

    @Override
    public void genererRappelRetard(Emprunt emprunt) {
        if (emprunt.getDateFin().isBefore(LocalDate.now())) {
            Rappel rappel = new Rappel();
            rappel.setEmprunt(emprunt);
            rappel.setDateRappel(LocalDate.now());
            rappelRepository.save(rappel);

        }
    }
}
