package br.edu.lftc;

public interface InterfaceAutonomo {
     boolean isPossible(String alfabeto);
     int editAutonom(int estados, int num_letras, String[] alfabetocompleto);
     void setTransition(int qi, String element, int qf);

}
