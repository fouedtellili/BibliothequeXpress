package com.example.bibliothequexpress.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

}
