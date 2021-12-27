package com.games.dto;


import com.games.entity.Games;
import com.games.entity.GenderEnum;
import org.jetbrains.annotations.NotNull;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GamesOutputDTO {

    private Long id;

    private String name;

    private String description;

//    private GenderEnum gender;

//    private LocalDate releaseDate;

    public GamesOutputDTO(Games games){
        this.id = games.getId();
        this.name = games.getName();
        this.description = games.getDescription();
    }

    public static List<GamesOutputDTO> ListGamesOutputDTO(List<Games> listGames){
        List<GamesOutputDTO> listGamesOutputDTO = new ArrayList<>();
        for(Games games: listGames){
            GamesOutputDTO gamesOutputDTO = new GamesOutputDTO(games);
            listGamesOutputDTO.add(gamesOutputDTO);
        }
        return listGamesOutputDTO;
    }

    public void toModel(Games games){

//        this.releaseDate = games.getReleaseDate();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public GenderEnum getGender() {
//        return gender;
//    }
//
//    public void setGender(GenderEnum gender) {
//        this.gender = gender;
//    }

//    public LocalDate getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(LocalDate releaseDate) {
//        this.releaseDate = releaseDate;
//    }
}
