package com.example.bibliothequexpress.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CarteBibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;
}
