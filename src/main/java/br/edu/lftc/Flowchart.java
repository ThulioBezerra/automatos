package br.edu.lftc;

import java.util.Arrays;
import java.util.Scanner;

public class Flowchart {
    public static Scanner scan = new Scanner(System.in);
    public static AutomnFDeterminate afd;
    public static AutomnFdWithNull afne;
    public static AutomnFIndeterminate afn;
    public static void init(){
        int menu_option = 0;
        String chars;
        do {
            System.out.println(
                "---------------------------\n" +
                "Menu de Automatos\n" +
                "---------------------------\n\n" +
                "1 - Automato Finito Determinado;\n" +
                "2 - Automato Finido Indeterminado;\n" +
                "3 - Automato Finito Indeterminado com mov nulo;\n" +
                "0- Sair\n"
            );
            menu_option = Integer.parseInt(scan.next());
            if (menu_option==0) continue;
            createAutomn(menu_option);
            createTransitions(menu_option);
            char answer;
            do {
                System.out.println("Digite uma cadeia para seu novo automato!");
                chars = scan.next();

                switch (menu_option) {
                    case 1:
                        afd.isPossible(chars);
                        break;
                    case 2:
                        afn.isPossible(chars);
                        break;
                    case 3:
                        afne = new AutomnFdWithNull();
                        afne.isPossible(chars);
                        break;
                }
                System.out.println("Quer digitar uma nova? [S/N]");
                answer = scan.next().toLowerCase().charAt(0);
            }while(answer != 'n');
        }while (menu_option != 0);

    }

    public static void createAutomn(int typeAuto){
        int number_of_states, number_of_letters;
        Integer[] end_states;
        String[] letters;
        if (typeAuto > 0 && typeAuto <= 2) {
            System.out.println("Quantas letras tem seu alfabeto? ");
            number_of_letters = Integer.parseInt(scan.next());
            System.out.println("Quantas estados tem seu automato? ");
            number_of_states = Integer.parseInt(scan.next());
            System.out.println("Quais as letras do seu alfabeto? Ex: a,b,c,d");
            letters = scan.next().split(",");
            System.out.println("Quais os estados finais do seu autonomo? Ex: 0->q0 | 1,3->q1,q3");
            String[] states = scan.next().split(",");
            end_states = new Integer[states.length];
            for (int i = 0; i < states.length; i++) {
                try {
                    end_states[i] = Integer.parseInt(states[i]);
                } catch (Exception e) {
                    System.out.println("Não forneceste um valor válido." + e.getMessage());
                }
            }
            switch (typeAuto){
                case 1:
                    afd = new AutomnFDeterminate(number_of_states,number_of_letters,letters,end_states);
                    break;
                case 2:
                    afn = new AutomnFIndeterminate(number_of_states,number_of_letters,letters,end_states);
                    break;
            }
    }
}
    public static void createTransitions(int typeAuto){

        switch (typeAuto) {
            case 1:
                char answer = 's';
                do{
                    System.out.println("Digite as transições entre os estados. Por exemplo: 0,a,1");
                    String[] data = scan.next().split(",");
                    afd.setTransition(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                    System.out.println("Deseja continuar? [S/N]");
                    answer = scan.next().toLowerCase().charAt(0);
                }while(answer!='n');
                break;
            case 2:
                afn.createTransition();
                int[][] possible_states = new int[afn.num_of_letters][afn.num_of_states];
                do{
                    int index = 0;
                    System.out.println("Digite as transições entre os estados. Por exemplo: 0,a,1");
                    String[] data = scan.next().split(",");
                    //Declarações
                    int qi = Integer.parseInt(data[0]);
                    String element = data[1];
                    int qf = Integer.parseInt(data[2]);
                    index = possible_states[Arrays.asList(afn.alphabet).indexOf(element)][qi];
                    //Função + incrementação.
                    afn.setTransition(qi, element, qf, index);
                    possible_states[Arrays.asList(afn.alphabet).indexOf(element)][qi]++;
                    System.out.println("Deseja continuar? [S/N]");
                    answer = scan.next().toLowerCase().charAt(0);
                }while(answer!='n');
                break;
            case 3:
                break;
            case 0:
                break;
            default:
                System.out.println("Entrada não reconhecida, tente novamente.");
        }
    }
}
