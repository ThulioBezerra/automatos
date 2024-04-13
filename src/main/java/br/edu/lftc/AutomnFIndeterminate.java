package br.edu.lftc;

import java.util.Arrays;
import java.util.Scanner;

public class AutomnFIndeterminate implements InterfaceAutonomo{
    int num_estados;
    int qt_letras;
    String[] alfabeto;
    Integer[] final_states;
    int initial_state;
    int[][][] transictionTable;
    public AutomnFIndeterminate(int estados, int num_letras, String[] alfabetocompleto, Integer[] finais){
        this.num_estados = estados;
        this.qt_letras = num_letras;
        this.alfabeto = alfabetocompleto;
        transictionTable = new int[num_estados][qt_letras][num_estados];
        this.final_states = finais;
    }

    @Override
    public boolean isPossible(String cadeia) {
        int[] state_tests = {};
        int[] finalStates = test(cadeia, state_tests, 0);
        return false;
    }

    private int[] test(String cadeia, int[] stateTests, int i) {
        if(i==cadeia.length()){
            if(aceppt(stateTests)){
                return stateTests;
            }else {
                System.out.println("<<<BackTrack>>> fim da cadeia");
            }
        }
        Integer simbolo = Arrays.asList(this.alfabeto).indexOf(cadeia.charAt(i));
        for (int j = 0; j < num_estados ; j++) {
            int[] novosEstados = transictionTable[i][simbolo];
            if (novosEstados.length!=0){
                return null;
            }
            int[] transicoes = test(cadeia,novosEstados,i+1);
            if(transicoes != null) return transicoes;

        }
        return null;
    }

    private boolean aceppt(int[] stateTests) {
        if (stateTests == null) return false;
        for (Integer state:stateTests) {
            for (Integer final_state:this.final_states) {
                if (state==final_state){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public int editAutonom(int estados, int num_letras, String[] alfabetocompleto) {
        return 0;
    }

    @Override
    public void setTransition(int qi, String element, int qf) {

    }

    public void setTransition(int qi, String element, int qf, int i) {
        transictionTable[qi][Arrays.asList(alfabeto).indexOf(element)][i] = qf;
    }
}
