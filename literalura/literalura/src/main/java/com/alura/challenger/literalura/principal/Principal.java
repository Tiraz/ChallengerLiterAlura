package com.alura.challenger.literalura.principal;

import com.alura.challenger.literalura.model.DadosGutenDex;
import com.alura.challenger.literalura.model.Livro;
import com.alura.challenger.literalura.model.LivroGutenDex;
import com.alura.challenger.literalura.service.ConsumirAPI;
import com.alura.challenger.literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    ConsumirAPI consumirAPI = new ConsumirAPI();

    ConverteDados converteDados = new ConverteDados();

    Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {

        var escolha = -1;
        while (escolha != 0) {

            System.out.println("""
                    -----------Litera-Alura----------
                    1- Buscar livro por nome
                    2-
                    3-
                    4-
                    5-
                    
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

        List<Livro> livros = new ArrayList<>();

        for (int i = 0; i <dados.livro().size() ; i++) {
            Livro livro = new Livro(dados, i);
            livros.add(livro);
        }

        livros.forEach(System.out::println);


    }
}
