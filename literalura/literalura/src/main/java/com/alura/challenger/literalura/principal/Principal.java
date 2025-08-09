package com.alura.challenger.literalura.principal;

import com.alura.challenger.literalura.model.Autor;
import com.alura.challenger.literalura.model.DadosGutenDex;
import com.alura.challenger.literalura.model.Livro;
import com.alura.challenger.literalura.model.LivroGutenDex;
import com.alura.challenger.literalura.repositorio.AutorRepository;
import com.alura.challenger.literalura.repositorio.LivroRepository;
import com.alura.challenger.literalura.service.ConsumirAPI;
import com.alura.challenger.literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    ConsumirAPI consumirAPI = new ConsumirAPI();

    ConverteDados converteDados = new ConverteDados();

    Scanner scanner = new Scanner(System.in);

    private AutorRepository repositorio;
    private LivroRepository livroRepositorio;

    public Principal() {
    }

    public Principal(AutorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Principal(AutorRepository repositorio, LivroRepository livroRepositorio) {
        this.repositorio = repositorio;
        this.livroRepositorio = livroRepositorio;
    }

    public void exibirMenu() {

        var escolha = -1;
        while (escolha != 0) {

            System.out.println("""
                    -----------Litera-Alura----------
                    1- Buscar livro por título
                    2- Listar livros registrados
                    3- Listar auttores registrados
                    4- Listar autores vivos em um determinado ano
                    5- listar livros em um determinado idioma
                    
                    0- Sair
                    """);

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    buscarLivroPorNome();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 0:
                    System.out.println("0");
                    break;
                default:
                    System.out.println("default");
                    break;
            }


        }

    }

    private void buscarLivroPorNome() {
        System.out.println("Digite o nome do livro:");
        var nome = scanner.nextLine();
        String endereco = "http://gutendex.com/books/?search=" + nome.toLowerCase().trim();
        var json = consumirAPI.obterDados(endereco);

        DadosGutenDex dados = converteDados.obterDados(json, DadosGutenDex.class);

        Autor autor = new Autor(dados.livro().get(0).autor().get(0));
        repositorio.save(autor);

        Livro livro = new Livro(dados, 0, autor);
        livroRepositorio.save(livro);

        System.out.println(autor);
        System.out.println();
        System.out.println(livro);


    }
}
