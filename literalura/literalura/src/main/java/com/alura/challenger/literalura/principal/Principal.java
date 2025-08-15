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
                        
                           1 - Buscar livro por título
                           2 - Listar livros registrados
                           3 - Listar autores registrados
                           4 - Listar autores vivos em um determinado ano
                           5 - Listar livros em um determinado idioma
                           
                           0 - Sair
                    """);

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    buscarLivroPorNome();
                    break;
                case 2:
                    listarTodosLivros();
                    break;
                case 3:
                    listarTodosAutores();
                    break;
                case 4:
                    listarAutoresVivosEm();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Escolha um valor valido!");
                    break;
            }


        }

    }


    private void buscarLivroPorNome() {
        System.out.println("Digite o nome do livro:");
        var nome = scanner.nextLine();
        nome = nome.replace(" ", "+");
        String endereco = "http://gutendex.com/books/?search=" + nome.toLowerCase().trim();
        var json = consumirAPI.obterDados(endereco);
        System.out.println(endereco);

        DadosGutenDex dados = converteDados.obterDados(json, DadosGutenDex.class);

        if (dados.livro().size() > 0) {
            Autor autor = new Autor(dados.livro().get(0).autor().get(0));
            repositorio.save(autor);

            Livro livro = new Livro(dados, 0, autor);
            livroRepositorio.save(livro);

            System.out.println(autor);
            System.out.println();
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }

    }

    private void listarTodosLivros() {
        List<Livro> livros = livroRepositorio.findAll();

        if (livros.size() >= 1) {
            livros.forEach(System.out::println);
        } else {
            System.out.println("Você não tem nenhum livro salvo :(");
        }
    }

    private void listarTodosAutores() {
        List<Autor> autores = repositorio.findAll();

        if (autores.size() >= 1) {
            autores.forEach(System.out::println);
        } else {
            System.out.println("Você não tem nenhum autor salvo :(");
        }
    }

    private void listarAutoresVivosEm() {
        System.out.println("Digite o ano para a pesquisa:");
        var ano = scanner.nextInt();

        List<Autor> autores = repositorio.findAnoVivo(ano);

        if (autores.size() > 0) {
            autores.forEach(System.out::println);
        } else {
            System.out.println("Nenhum ao autor registrado, estava vivo na data escolhida.");
        }

    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Digite a sigla referente ao idioma para o filtro:
                pt - Português
                es - Espanhol
                fr - Francês
                en - inglês
                """);
        var idioma = scanner.nextLine();

        List<Livro> livros = livroRepositorio.findByIdioma(idioma.toLowerCase().trim());

        if (livros.size() > 0) {
            livros.forEach(System.out::println);
        } else {
            System.out.println("Não a nenhum livro no idioma selecionado nnos registros.");
        }
    }

}
