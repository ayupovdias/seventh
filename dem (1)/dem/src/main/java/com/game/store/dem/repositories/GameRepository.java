package com.game.store.dem.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.game.store.dem.entities.Game;
@Transactional
@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
}
