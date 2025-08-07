package com.alura.challenger.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorGutenDex(@JsonAlias("name") String nome,
                            @JsonAlias("birth_year") Integer anoNasceminto,
                            @JsonAlias("death_year") Integer anoMorte) {
}