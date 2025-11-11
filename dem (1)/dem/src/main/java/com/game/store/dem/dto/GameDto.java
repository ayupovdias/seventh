package com.game.store.dem.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
@Setter
@Getter
@Builder
public class GameDto {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String release;
    private String developer;
    private String publisher;
    private int ageRating;
}
