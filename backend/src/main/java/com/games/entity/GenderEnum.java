package com.games.entity;

public enum GenderEnum {
    TERROR("Terror"),
    ACAO("Ação"),
    AVENTURA("Aventura"),
    INFATIL("Infatil");

    private final String displayValue;

    GenderEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }
}
