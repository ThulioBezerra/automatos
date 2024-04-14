package br.edu.lftc;

public class AutomnFdWithNull implements InterfaceAutonomo{
    int num_of_states;
    int num_of_letters;
    String[] alphabet;
    Integer[] end_states;
    int[][] transictionTable;
    public AutomnFdWithNull(int states, int num_of_letters, String[] complete_alphabet, Integer[] end_states){
        this.num_of_states = states;
        this.num_of_letters = num_of_letters;
        this.alphabet = complete_alphabet;
        transictionTable = new int[num_of_states][num_of_letters];
        this.end_states = end_states;
    }
    @Override
    public boolean isPossible(String alphabet) {
        return false;
    }

    @Override
    public int editAutonom(int states, int num_of_letters, String[] complete_alphabet) {
        return 0;
    }

    @Override
    public void setTransition(int qi, String element, int qf) {

    }
}
