package br.edu.lftc;

import java.util.Arrays;

public class AutomnFDeterminate implements InterfaceAutonomo{
    int num_states;
    int num_letters;
    String[] alphabet;
    Integer[] end_states;
    //Esse estado sempre será o q0 por padrão
    int initial_state;
    int[][]transictionTable;
    public AutomnFDeterminate(int states, int num_letters, String[] complete_alphabet, Integer[] end_states){
        this.num_states = states;
        this.num_letters = num_letters;
        this.alphabet = complete_alphabet;
        transictionTable = new int[num_states][num_letters];
        this.end_states = end_states;
        /* * a  b
        * q0 0  1
        * q1 1  0
        * */
    }

    @Override
    public boolean isPossible(String chars) {
        int current_state=0,i=0;
        String current_char="";

        while(i < chars.length()){
            imprimeCI(chars,current_state, i);
            current_char = chars.charAt(i++) + "";
            for (int j = 0; j < num_letters; j++) {
                if (current_char.equals(this.alphabet[j])){
                    current_state = transictionTable[current_state][j];
                }
            }
            }
        imprimeCI(chars,current_state, i);
        if (Arrays.asList(end_states).contains(current_state)){
            System.out.println("É possível");
        }else{
            System.out.println("Não é possivel");
        }
        return true;
    }

    @Override
    public void setTransition(int qi, String element, int qf) {
        transictionTable[qi][Arrays.asList(alphabet).indexOf(element)] = qf;
    }
    public static void imprimeCI(String cadeia, int estado, int posicao) {
        System.out.print(cadeia.substring(0, posicao));
        System.out.print("[q" + estado+"]");
        System.out.println(cadeia.substring(posicao));
    }
}
