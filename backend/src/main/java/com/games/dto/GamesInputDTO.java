package com.games.dto;


import com.games.entity.Games;
import com.games.entity.GenderEnum;


import java.time.LocalDate;

public class GamesInputDTO {



    private String name;

    private String description;

    private GenderEnum gender;

    private LocalDate releaseDate;


    public Games toModel(){
        Games games = new Games();
        games.setName(name);
        games.setDescription(description);
        return games;
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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
