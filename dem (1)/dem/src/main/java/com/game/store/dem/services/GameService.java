package com.game.store.dem.services;

import com.game.store.dem.dto.GameDto;
import java.util.List;

public interface GameService {
    List<GameDto> getGames();
    GameDto getGame(Long id);
    GameDto addGame(GameDto gameDto);
    GameDto updateGame(GameDto gameDto, Long id);
    boolean deleteGame(Long id);
}
