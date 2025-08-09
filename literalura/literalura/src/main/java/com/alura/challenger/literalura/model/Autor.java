package com.alura.challenger.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private Integer aniversario;

    private Integer anoMorte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;


    public Autor() {
    }

    public Autor(AutorGutenDex autorGutenDex) {
        this.nome = autorGutenDex.nome();
        this.aniversario = autorGutenDex.anoNasceminto();
        this.anoMorte = autorGutenDex.anoMorte();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAniversario() {
        return aniversario;
    }

    public void setAniversario(Integer aniversario) {
        this.aniversario = aniversario;
    }

    public Integer getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Integer anoMorte) {
        this.anoMorte = anoMorte;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "--Autor--\n" +
                "Nome: " + nome + "\n" +
                "Ano nascimento: " + aniversario + "\n" +
                "Ano morte: " + anoMorte + "\n";

    }
}
