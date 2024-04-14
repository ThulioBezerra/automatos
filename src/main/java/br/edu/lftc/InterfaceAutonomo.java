package br.edu.lftc;

public interface InterfaceAutonomo {
     boolean isPossible(String alphabet);
     int editAutonom(int states, int num_of_letters, String[] complete_alphabet);
     void setTransition(int qi, String element, int qf);
}
