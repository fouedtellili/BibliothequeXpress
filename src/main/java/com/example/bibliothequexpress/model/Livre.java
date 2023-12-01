package com.example.bibliothequexpress.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private String datePublication;
    private String numeroISBN;
    private int exemplairesDisponibles;

    @ManyToOne
    private Categorie categorie;



}
