package com.alura.challenger.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "livros")
public class Livro {


    private Long id;

    private String titulo;

    private Autor autor;

    private Long dowloadsNum;

    private List<String> idiomas;


    public Livro() {
    }

    public Livro(DadosGutenDex dados, int index) {
        this.titulo = dados.livro().get(index).titlo();
        this.autor = new Autor(dados.livro().get(index).autor().get(0));
        this.dowloadsNum = dados.livro().get(index).numeroDawloads();
        this.idiomas = new ArrayList<>(dados.livro().get(index).idioma());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getDowloadsNum() {
        return dowloadsNum;
    }

    public void setDowloadsNum(Long dowloadsNum) {
        this.dowloadsNum = dowloadsNum;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }


    @Override
    public String toString() {
        return "****Livro***\n" +
                "Título: " + titulo +"\n" +
                "Autor: " + autor.getNome() +"\n" +
                "Número de dowloads: " + dowloadsNum +"\n" +
                "Idiomas: " + idiomas +"\n";
    }
}
