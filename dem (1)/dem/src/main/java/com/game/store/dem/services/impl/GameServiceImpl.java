package com.game.store.dem.services.impl;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;

import com.game.store.dem.repositories.GameRepository;
import com.game.store.dem.services.GameService;
import com.game.store.dem.dto.GameDto;
import com.game.store.dem.entities.Game;


@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    @Override
    public List<GameDto> getGames(){
        List<Game> games=gameRepository.findAll();
        List<GameDto> gamesDto=new ArrayList<>();
        games.forEach(game->{
           gamesDto.add(toDto(game));
        });
        return gamesDto;
    }
    @Override
    public GameDto getGame(Long id){
        Game game=gameRepository.findById(id).orElse(null);
        if(game==null){
            return null;
        }
        return toDto(game);
    }
    @Override
    public GameDto addGame(GameDto gameDto){
        Game game=toEntity(gameDto);
        Game addedGame=gameRepository.save(game);
        return toDto(addedGame);
    }
    @Override
    public GameDto updateGame(GameDto gameDto, Long id){
        GameDto dto=getGame(id);
        if(dto==null){
            return null;
        }
        if(gameDto.getTitle()!=null){
            dto.setTitle(gameDto.getTitle());
        }
        if(gameDto.getPrice()!=0){
            dto.setPrice(gameDto.getPrice());
        }
        if(gameDto.getRelease()!=null){
            dto.setRelease(gameDto.getRelease());
        }
        if(gameDto.getDeveloper()!=null){
            dto.setDeveloper(gameDto.getDeveloper());
        }
        if(gameDto.getPublisher()!=null){
            dto.setPublisher(gameDto.getPublisher());
        }
        if(gameDto.getAgeRating()!=0){
            dto.setAgeRating(gameDto.getAgeRating());
        }
        Game game=gameRepository.save(toEntity(dto));
        return toDto(game);
    }
    @Override
    public boolean deleteGame(Long id){
        GameDto gameDto=getGame(id);
        if(gameDto==null){
            return false;
        }
        gameRepository.deleteById(id);
        return true;
    }
    public GameDto toDto(Game game){

        GameDto gameDto=GameDto.
                builder().
                id(game.getId()).
                title(game.getTitle()).
                developer(game.getDeveloper()).
                publisher(game.getPublisher()).
                price(game.getPrice()).
                ageRating(game.getAgeRating()).
                release(game.getRelease()).
                build();
        return gameDto;
    }
    public Game toEntity(GameDto gameDto){
        if(gameDto.getAgeRating()<0){
            gameDto.setAgeRating(0);
        }
        else if(gameDto.getAgeRating()>99){
            gameDto.setAgeRating(99);
        }
        Game game =new Game();
        game.setId(gameDto.getId());
        game.setTitle(gameDto.getTitle());
        game.setDeveloper(gameDto.getDeveloper());
        game.setRelease(gameDto.getRelease());
        game.setPublisher(gameDto.getPublisher());
        game.setPrice(gameDto.getPrice());
        game.setAgeRating(gameDto.getAgeRating());
        return game;
    }
}
