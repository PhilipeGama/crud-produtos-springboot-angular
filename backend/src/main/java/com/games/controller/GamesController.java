package com.games.controller;


import com.games.dto.GamesInputDTO;
import com.games.dto.GamesOutputDTO;
import com.games.entity.Games;
import com.games.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GamesService gamesService;


    @GetMapping
    public List<GamesOutputDTO> getAllGames(){
        List<Games> listGames = gamesService.findAllGames();
        List<GamesOutputDTO> listGamesOutPutDTO = GamesOutputDTO.ListGamesOutputDTO(listGames);
        return listGamesOutPutDTO;
    }

    @GetMapping("/{id}")
    public GamesOutputDTO getGames(@PathVariable(value = "id") long id){
        Optional<Games> gamesOptional = gamesService.findGames(id);


        if(gamesOptional.isPresent()){
            Games games = gamesOptional.get();
            GamesOutputDTO gamesDTO = new GamesOutputDTO(games);
            return gamesDTO;
        }


        return null;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Games createGames(@RequestBody GamesInputDTO gamesInputDTO){
        System.out.println("post");
        Games games = gamesInputDTO.toModel();
        return gamesService.saveGames(games);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Games updateGames(@PathVariable(value = "id") long id, @RequestBody GamesInputDTO newGamesDTO){
        Games games = newGamesDTO.toModel();
        return gamesService.updateGames(id,games);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGames(@PathVariable(value = "id") long id){
        gamesService.deleteGames(id);
    }


}
