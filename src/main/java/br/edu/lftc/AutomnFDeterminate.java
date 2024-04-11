package br.edu.lftc;

import java.util.Arrays;
import java.util.Scanner;

public class AutomnFDeterminate implements InterfaceAutonomo{
    int num_estados;
    int qt_letras;
    String[] alfabeto;
    Integer[] final_states;
    //Esse estado sempre será o q0 por padrão
    int initial_state;
    int[][]transictionTable;
    public AutomnFDeterminate(int estados, int num_letras, String[] alfabetocompleto, Integer[] finais){
        this.num_estados = estados;
        this.qt_letras = num_letras;
        this.alfabeto = alfabetocompleto;
        transictionTable = new int[num_estados][qt_letras];
        this.final_states = finais;
        /* * a  b
        * q0 0  1
        * q1 1  0
        *
        *
        * */
    }
    public Scanner leitor = new Scanner(System.in);
    @Override
    public boolean isPossible(String cadeia) {
        int estado_atual=0,i=0;
        String caractere_atual="";
        while(i < cadeia.length()){
            caractere_atual = cadeia.charAt(i++) + "";
            for (int j = 0; j < qt_letras; j++) {
                if (caractere_atual.equals(this.alfabeto[j])){
                    estado_atual = transictionTable[estado_atual][j];
                }
            }
            }
        if (Arrays.asList(final_states).contains(estado_atual)){
            System.out.println("É possível");
        }else{
            System.out.println("Não é possivel");
        }

        return true;
    }

    @Override
    public int editAutonom(int estados, int num_letras, String[] alfabetocompleto) {
        return 0;
    }

    @Override
    public void setTransition(int qi, String element, int qf) {
        transictionTable[qi][Arrays.asList(alfabeto).indexOf(element)] = qf;
    }
}
