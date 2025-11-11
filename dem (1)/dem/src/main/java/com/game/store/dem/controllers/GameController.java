package com.game.store.dem.controllers;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import org.springframework.http.*;

import com.game.store.dem.services.GameService;
import com.game.store.dem.dto.GameDto;

import java.util.List;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<?> getGames(){
        List<GameDto> gamesDto=gameService.getGames();
        if(gamesDto.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gamesDto, HttpStatus.OK);

    }
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getGame(@PathVariable("id") Long id){
        GameDto gameDto=gameService.getGame(id);

        return ResponseEntity.ok(gameDto);
    }
    @PostMapping
    public ResponseEntity<?> addGame(@RequestBody GameDto gameDto){
        GameDto dto=gameService.addGame(gameDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<?> updateGame(@PathVariable("id") Long id, @RequestBody GameDto gameDto){
        GameDto dto=gameService.updateGame(gameDto, id);
        if(Objects.isNull(dto)){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable("id") Long id){
        boolean result=gameService.deleteGame(id);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
