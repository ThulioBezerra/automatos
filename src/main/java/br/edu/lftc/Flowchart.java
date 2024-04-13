package br.edu.lftc;

import java.util.Scanner;

public class Flowchart {
    public static Scanner leitor = new Scanner(System.in);
    public static AutomnFDeterminate afd;
    public static AutomnFdWithNull afne;
    public static AutomnFIndeterminate afn;
    public static void  init(){
        boolean solved = true;
        int option=0;
        String cadeia;
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
            option = Integer.parseInt(leitor.next());
            createAuto(option);
            createTransitions(option);
            System.out.println("Digite uma cadeia para seu novo automato!");
            cadeia = leitor.next();
            switch (option){
                case 1:
                    afd.isPossible(cadeia);
                    break;
                case 2:
                    afn.isPossible(cadeia);
                    break;
                case 3:
                    afne.isPossible(cadeia);
                    break;
            }
        }while(solved !=true);
    }

    public static void createAuto(int typeAuto){
        int estados_create, qt_letras;
        Integer[] estados_finais;
        String[] letras;
        if (typeAuto>0 || typeAuto<=3) {
            System.out.println("Quantas letras tem seu alfabeto? ");
            qt_letras = Integer.parseInt(leitor.next());
            System.out.println("Quantas estados tem seu automato? ");
            estados_create = Integer.parseInt(leitor.next());
            System.out.println("Quais as letras do seu alfabeto? Ex: a,b,c,d");
            letras = leitor.next().split(",");
            System.out.println("Quais os estados finais do seu autonomo? Ex: 0->q0 | 1,3->q1,q3");
            String[] estados = leitor.next().split(",");
            estados_finais = new Integer[estados.length];
            for (int i = 0; i < estados.length; i++) {
                try {
                    estados_finais[i] = Integer.parseInt(estados[i]);
                } catch (Exception e) {
                    System.out.println("Não forneceste um valor válido." + e.getMessage());
                }
            }
            switch (typeAuto){
                case 1:
                    afd = new AutomnFDeterminate(estados_create,qt_letras,letras,estados_finais);
                    break;
                case 2:
                    afn = new AutomnFIndeterminate(estados_create,qt_letras,letras,estados_finais);
                    break;
                case 3:
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
                    String[] data = leitor.next().split(",");
                    afd.setTransition(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                    System.out.println("Deseja continuar? [S/N]");
                    answer = leitor.next().toLowerCase().charAt(0);
                }while(answer!='n');
                break;
            case 2:
                int[] index = new int[afn.num_estados];
                do{
                    System.out.println("Digite as transições entre os estados. Por exemplo: 0,a,1");
                    String[] data = leitor.next().split(",");
                    //Declarações
                    int qi = Integer.parseInt(data[0]);
                    String element = data[1];
                    int qf = Integer.parseInt(data[2]);
                    int posicao = index[Integer.parseInt(data[0])];
                    //Função + incrementação.
                    afn.setTransition(qi, element, qf, posicao);
                    index[Integer.parseInt(data[0])] = posicao++;
                    System.out.println("Deseja continuar? [S/N]");
                    answer = leitor.next().toLowerCase().charAt(0);
                }while(answer!='n');
                break;
            case 3:
                do{
                    System.out.println("Digite as transições entre os estados. Por exemplo: 0,a,1 ou 0,null,2 para ε");
                    String[] data = leitor.next().split(",");
                    afd.setTransition(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]));
                    System.out.println("Deseja continuar? [S/N]");
                    answer = leitor.next().toLowerCase().charAt(0);
                }while(answer!='n');
                break;
            case 0:
                break;
            default:
                System.out.println("Entrada não reconhecida, tente novamente.");
        }
    }
}
