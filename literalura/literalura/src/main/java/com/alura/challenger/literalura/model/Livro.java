package com.alura.challenger.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Autor autor;

    private Long dowloadsNum;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "livro_idiomas", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "idioma")
    private List<String> idiomas = new ArrayList<>();;


    public Livro() {
    }

    public Livro(DadosGutenDex dados, int index, Autor autor) {
        this.titulo = dados.livro().get(index).titlo();
        this.autor = autor;
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
        var nomeAutor = "Não encontrado";
        if (autor != null) {
            nomeAutor = autor.getNome();
        }

        return "****Livro***\n" +
                "Título: " + titulo +"\n" +
                "Autor: " + nomeAutor +"\n" +
                "Número de dowloads: " + dowloadsNum +"\n" +
                "Idiomas: " + idiomas +"\n";
    }
}
