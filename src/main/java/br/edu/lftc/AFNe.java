package br.edu.lftc;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//cadeia aceita 010
//cadeia rejeita 111
public class AFNe {
    // estados Q ={q1,q2,q3}
    // alfabeto aceito{0,1,2}

    static int[][][] transicao = { { { 1 }, {}, {} },
            { {}, { 2 }, { 2 } },
            { {}, {}, {} } };

    static int[][] transicvazia = { {}, { 0 }, { 0 } };
    static int estadoinicial = 0;
    static int[] aceitacao = { 0 };

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String cadeia;
        System.out.println("imforme uma cadeia:");
        cadeia = ler.nextLine();
        int posicao = 0;
        int estados[] = efecho(new int[] { estadoinicial });

        while (posicao < cadeia.length()) {
            imprimeCI(cadeia, estados, posicao);
            int[] novosEST = new int[] {};
            int elemento = Integer.parseInt(cadeia.substring(posicao, posicao + 1));
            for (int i : estados) {
                int[] destinoTrasic = transicao[i][elemento];
                novosEST = uniao(novosEST, destinoTrasic);
                novosEST = efecho(novosEST);
            }
            estados = novosEST;
            if (estados.length == 0) {
                break;
            }
            posicao++;
        }

        imprimeCI(cadeia, estados, posicao);

        if (aceita(estados)) {
            System.out.println("aceita");
        } else {
            System.out.println("rejeita");
        }
    }

    public static int[] efecho(int[] estados) {
        int[] efecho = estados;
        for (int i : estados) {
            int[] fechoAux = transicvazia[i];
            int[] fechoAux2 = efecho(fechoAux);
            efecho = uniao(efecho, fechoAux);
            efecho = uniao(efecho, fechoAux2);

        }
        return efecho;
    }

    public static int[] uniao(int[] estados, int[] novosEST) {
        Set<Integer> uniao = new TreeSet<>();
        for (int i : estados)
            uniao.add(i);
        for (int i : novosEST)
            uniao.add(i);
        int[] ret = new int[uniao.size()];
        int j = 0;
        for (int i : uniao)
            ret[j++] = i;
        return ret;
    }

    public static boolean aceita(int[] estados) {
        if (estados == null)
            return false;
        for (int i : estados) {
            for (int j : aceitacao) {
                if (i == j) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void imprimeCI(String cadeia, int[] estado, int posicao) {
        System.out.print(cadeia.substring(0, posicao) + "{");
        for (int i = 0; i < estado.length; i++) {
            System.out.println("q" + estado[i]);
            if (i < estado.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}" + cadeia.substring(posicao));
    }

}
