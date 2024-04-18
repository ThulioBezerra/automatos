package br.edu.lftc;

import java.util.Arrays;
import java.util.TreeSet;

public class AutomnFdWithNull implements InterfaceAutonomo{

    int[][][] transictionTable = { { { 1 }, {}, {} },
            { {}, { 2 }, { 2 } },
            { {}, {}, {} } };

    int[][] transictionTableNull = { {}, { 0 }, { 0 } };
    String[] alphabet = {"0","1"};
    int[] end_states = {1};

    @Override
    public boolean isPossible(String chars) {
        int[] state_tests = {0};
        int state_fecho[] = efecho(state_tests);
        int i = 0;
        while (i < chars.length()) {
            imprimeCI(chars, state_fecho, i);
            System.out.println("");
            int[] novosEST = new int[] {};
            Integer symbol = Arrays.asList(this.alphabet).indexOf(chars.charAt(i)+ "");
            for (int state : state_fecho) {
                int[] destinoTrasic = this.transictionTable[state][symbol];
                novosEST = uniao(novosEST, destinoTrasic);
                novosEST = efecho(novosEST);
            }
            state_fecho = novosEST;
            if (state_tests.length == 0) {
                break;
            }
            i++;
        }

        imprimeCI(chars, state_fecho, i);
        System.out.println("");
        if (aceita(state_fecho)) {
            System.out.println("aceita");
        } else {
            System.out.println("rejeita");
        }
        return false;
    }
    public  boolean aceita(int[] estados) {
        if (estados == null)
            return false;
        for (int i : estados) {
            for (int j : this.end_states) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int[] uniao(int[] estados, int[] novosEST) {
        TreeSet<Integer> uniao = new TreeSet<>();
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
    public int[] efecho(int[] estados) {
        int[] efecho = estados;
        for (int state_qi : estados) {
            int[] fechoAux = this.transictionTableNull[state_qi];
            int[] fechoAux2 = efecho(fechoAux);
            efecho = uniao(efecho, fechoAux);
            efecho = uniao(efecho, fechoAux2);
        }
        return efecho;
    }
    @Override
    public void setTransition(int qi, String element, int qf) {
    }
    public static void imprimeCI(String cadeia, int[] estado, int posicao) {
        System.out.print(cadeia.substring(0, posicao) + "{");
        for (int i = 0; i < estado.length; i++) {
            System.out.print("q" + estado[i]);
            if (i < estado.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}" + cadeia.substring(posicao));
    }
}
