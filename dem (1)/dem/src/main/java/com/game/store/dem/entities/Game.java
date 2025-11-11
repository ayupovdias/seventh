package com.game.store.dem.entities;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length=25)
    private String title;
    @Column(length=500)
    private String description;
    private int price;
    @Column(length=20)
    private String release;
    @Column(length=25)
    private String developer;
    @Column(length=25)
    private String publisher;
    private int ageRating;
}
