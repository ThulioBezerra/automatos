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
        Integer[] estados_finais;
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
                System.out.println("Quais os estados finais do seu autonomo? Ex: 0->q0 | 1,3->q1,q3");
                String[] estados = leitor.next().split(",");
                estados_finais = new Integer[estados.length];
                for (int i = 0; i < estados.length; i++) {
                    try {
                        estados_finais[i] = Integer.parseInt(estados[i]);
                    } catch (Exception e) {
                        System.out.println("Unable to parse string to int: " + e.getMessage());
                    }
                }
                switch (option) {
                    case 1:
                        afd = new AutomnFDeterminate(estados_main,qt_letras_main,letras_main,estados_finais);
                        boolean determinate = true;
                        char answer = 's';
                        do{
                            System.out.println("Digite as transições entre os estados. Por exemplo: 0,a,1");
                            String[] data = leitor.next().split(",");
                            afd.setTransition(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                            System.out.println("Deseja continuar? [S/N]");
                            answer = leitor.next().toLowerCase().charAt(0);
                        }while(determinate==true && answer!='n');
                        System.out.println("Digite uma tentativa");
                        String tentativa = leitor.next();
                        afd.isPossible(tentativa);
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