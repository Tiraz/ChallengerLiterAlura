package com.alura.challenger.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroGutenDex(@JsonAlias ("title") String titlo,
                            @JsonAlias("authors") List<AutorGutenDex> autor,
                            @JsonAlias("download_count") Long numeroDawloads,
                            @JsonAlias("languages") List<String> idioma) {
}
