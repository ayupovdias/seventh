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
        if(gamesDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(gamesDto);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<?> getGame(@PathVariable("id") Long id){
        GameDto gameDto=gameService.getGame(id);
        if(Objects.isNull(gameDto)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
