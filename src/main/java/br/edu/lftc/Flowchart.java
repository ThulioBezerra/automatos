package br.edu.lftc;

import java.util.Scanner;

public class AutomnFdWithNull implements InterfaceAutonomo {
    int num_estados;
    int qt_letras;
    String[] alfabeto;
    Integer[] final_states;
    int[][] transictionTable;

    public AutomnFdWithNull(int estados, int num_letras, String[] alfabetocompleto, Integer[] finais) {
        this.num_estados = estados;
        this.qt_letras = num_letras;
        this.alfabeto = alfabetocompleto;
        transictionTable = new int[num_estados][qt_letras];
        this.final_states = finais;
    }

    @Override
    public boolean isPossible(String alfabeto) {
        return false;
    }

    @Override
    public int editAutonom(int estados, int num_letras, String[] alfabetocompleto) {
        return 0;
    }

    @Override
    public void setTransition(int qi, String element, int qf) {

    }
}