package com.alura.challenger.literalura.model;

import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name = "autores")
public class Autor {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private List<Livro> livros;


}
