package com.games.repository;


import com.games.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GamesRepository extends JpaRepository<Games, Long> {

}
