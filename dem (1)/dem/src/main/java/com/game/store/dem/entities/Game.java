package com.game.store.dem.entities;

import lombok.Data;
import jakarta.persistence.*;
@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length=25)
    private String title;
    private int price;
    @Column(length=20)
    private String release;
    @Column(length=25)
    private String developer;
    @Column(length=25)
    private String publisher;
    private int ageRating;
}
