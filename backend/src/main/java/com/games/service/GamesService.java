package com.games.service;

import com.games.entity.Games;
import com.games.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {


    @Autowired
    private GamesRepository gamesRepository;


    public Optional<Games> findGames(long id){
        return gamesRepository.findById(id);
    }

    public List<Games> findAllGames(){
        return gamesRepository.findAll();
    }

    public Games saveGames(Games games){
       return gamesRepository.save(games);
    }

    public Games updateGames(long id, Games newGames){
        Optional<Games> oldGames = gamesRepository.findById(id);
        if(oldGames.isPresent()){
            newGames.setId(oldGames.get().getId());
            return gamesRepository.save(newGames);
        }
        return null;
    }

    public void deleteGames(long id){
        Optional<Games> findGames = gamesRepository.findById(id);
        if(findGames.isPresent()) {
            gamesRepository.delete(findGames.get());
        }
    }


}
