package br.edu.lftc;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner leitor = new Scanner(System.in);
    public static AutomnFDeterminate afd;
    public static AutomnFdWithNull afie;
    public static AutomnFIndeterminate afi;
    public static void main(String[] args) {
        boolean solved = true;
        int estados_main, qt_letras_main;
        String[] letras_main;

        do {
            System.out.println("""
                    ---------------------------
                    Menu de Automatos
                    ---------------------------

                    1 - Automato Finito Determinado;
                    2 - Automato Finido Indeterminado;
                    3 - Automato Finito Indeterminado com mov nulo;
                    0- Sair
                    """);
            int option = Integer.parseInt(leitor.next());
            if (option>=0 || option<=3) {
                System.out.println("Quantas letras tem seu alfabeto? ");
                qt_letras_main = Integer.parseInt(leitor.next());
                System.out.println("Quantas estados tem seu automato? ");
                estados_main = Integer.parseInt(leitor.next());
                System.out.println("Quais as letras do seu alfabeto? ");
                letras_main = leitor.next().split(",");
                System.out.println("Quais os estados finais do seu autonomo? ");
                System.out.println(Arrays.asList(letras_main));
                switch (option) {
                    case 1:
                        afd.init();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Entrada não reconhecida, tente novamente.");
                }
            }
        }while(solved !=true);
    }


}