package br.edu.lftc;

import java.util.Arrays;
import java.util.Scanner;

public class AutomnFIndeterminate implements InterfaceAutonomo{
    int num_of_states;
    int num_of_letters;
    String[] alphabet;
    Integer[] end_states;
    int initial_state;
    int[][][] transictionTable;
    public AutomnFIndeterminate(int states, int num_of_letters, String[] complete_alphabet, Integer[] end_states){
        this.num_of_states = states;
        this.num_of_letters = num_of_letters;
        this.alphabet = complete_alphabet;
        transictionTable = new int[num_of_states][num_of_letters][num_of_states];
        this.end_states = end_states;
    }

    @Override
    public boolean isPossible(String chars) {
        int[] state_tests = {0}; //q0
        int[] end_states = test(chars, state_tests, 0);
        if(aceppt(end_states)){
            System.out.println("Palavra aceita!");
        }else System.out.println("Rejeitada!");
        return false;
    }

    private int[] test(String chars, int[] stateTests, int i) {
        if(i==chars.length()){
            if(aceppt(stateTests)){
                return stateTests;
            }else {
                System.out.println("<<<BackTrack>>> fim da cadeia");
                return null;
            }
        }
        Integer symbol = Arrays.asList(this.alphabet).indexOf(chars.charAt(i)+ "");
        for (int j = 0; j < num_of_states ; j++) {
            int[] new_states = transictionTable[j][symbol];
            if (new_states.length==0){
                return null;
            }
            int[] transitions = test(chars,new_states,i+1);
            if(transitions != null) return transitions;

        }
        return null;
    }

    private boolean aceppt(int[] stateTests) {
        if (stateTests == null) return false;
        for (Integer state:stateTests) {
            for (Integer end_state:this.end_states) {
                if (state==end_state){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public int editAutonom(int states, int num_of_letters, String[] complete_alphabet) {
        return 0;
    }

    @Override
    public void setTransition(int qi, String element, int qf) {

    }
    
    public void setTransition(int qi, String element, int qf, int i) {
        transictionTable[qi][Arrays.asList(alphabet).indexOf(element)][i] = qf;
    }

    public void createTransition() {
        for (int i = 0; i < num_of_states; i++) {
            for (int j = 0; j < num_of_letters; j++) {
                for (int k = 0; k < num_of_states; k++) {
                    transictionTable[i][j][k] = -1;
                }
            }
        }
    }
}
