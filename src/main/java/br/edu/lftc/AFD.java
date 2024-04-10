package br.edu.lftc;

import java.util.ArrayList;
import java.util.Scanner;

public class AFD {

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);

        System.out.println("! O programa receberá inputs até que um valor vazio seja digitado (ENTER)\n");

        System.out.println("Informe o alfabeto: ");
        ArrayList<String> alfabeto = new ArrayList<>();
        do {
            alfabeto.add(usuario.nextLine());
        } while (alfabeto.get(alfabeto.size()-1) != "");

        System.out.println("Informe os estados: ");
        ArrayList<String> estados = new ArrayList<>();
        do {
            estados.add(usuario.nextLine());
        } while (estados.get(estados.size()-1) != "");


        System.out.println("Estados finais: ");
        ArrayList<String> finais = new ArrayList<>();
        do {
            finais.add(usuario.nextLine());
        } while (finais.get(finais.size()-1) != "");

        System.out.println("Estado inicial: ");
        int estado_inicial = usuario.nextInt();


        System.out.println("\nA tabela de transições: ");
        int transicao[][] = new int[estados.size()-1][alfabeto.size()-1];
        for (int i = 0; i < estados.size()-1; i++) {
            for (int j = 0; j < alfabeto.size()-1; j++) {
                System.out.println("estado "+estados.get(i)+" lendo a letra "+alfabeto.get(j)+" vai pro estado: ");
                transicao[i][j] = usuario.nextInt();
            }
        }
        usuario.nextLine();
        System.out.println("\nInforme uma palavra:");
        String palavra = usuario.nextLine();

        int posicao = 0;
        int estado = estado_inicial;
        char simbolo;

        int simboloint;
        while (posicao<palavra.length()) {
            simbolo = palavra.charAt(posicao);
            simboloint = Integer.parseInt(simbolo+"");
            estado = transicao[estado][simboloint];
            posicao++;
        }

        boolean check = false;
        finais.remove(finais.size()-1);
        for (String i: finais) {
            if (estado == Integer.parseInt(i+"")) {check = true;}
        }
        if (check) System.out.println("Palavra aceita!");
        else System.out.println("Palavra rejeitada.");
    }
}
