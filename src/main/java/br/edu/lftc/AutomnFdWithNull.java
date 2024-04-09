package br.edu.lftc;

import java.util.Scanner;

public class AutomnFdWithNull implements InterfaceAutonomo{
    int num_estados;
    int qt_letras;
    String[] alfabeto;
    int[] final_states;
    int initial_state;
    String[][] transictionTable;
    public AutomnFdWithNull(int estados, int num_letras, String[] alfabetocompleto){
        this.num_estados = estados;
        this.qt_letras = num_letras;
        this.alfabeto = alfabetocompleto;
        transictionTable = new String[num_estados][qt_letras];
    }
    @Override
    public boolean isPossible(String[] alfabeto) {
        return false;
    }

    @Override
    public int editAutonom(int estados, int num_letras, String[] alfabetocompleto) {
        return 0;
    }

    @Override
    public int setTransition(int qi, char element, int qf) {
        return 0;
    }
}
