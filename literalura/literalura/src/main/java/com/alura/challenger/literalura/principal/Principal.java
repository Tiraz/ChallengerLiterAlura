package com.alura.challenger.literalura.principal;

import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {

        var escolha = -1;
        while (escolha != 0) {

            System.out.println("""
                    -----------Litera-Alura----------
                    1- Buscar
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
                    System.out.println("1");
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
}
