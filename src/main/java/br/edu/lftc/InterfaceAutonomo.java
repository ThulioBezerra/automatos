package br.edu.lftc;

public interface InterfaceAutonomo {
    public boolean isPossible(String alfabeto);
    public int editAutonom(int estados, int num_letras, String[] alfabetocompleto);
    public void setTransition(int qi, String element, int qf);

}
