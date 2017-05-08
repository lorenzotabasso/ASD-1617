package ex2;

import java.util.*;

public class Leaf<T extends Comparable<T>> extends Tree<T> {

    public int dimensione() {
        return 0;
    }

    public int profondita() {
        return 0;
    }

    public int profondita2() {
        return 0;
    }

    public int grado () {
        return 0;
    }

    public int grado2 () {
        return 0;
    }

    public int maxgrado() {
        return 0;
    }

    public boolean binario() {
        return true;
    }

//--------------------------------------------------------------------------------------------------

    public void AggiungiFratelloDx (T elem) {
        System.out.println("Errore: Non puoi aggiungere un fratello a Leaf!\n");
        System.exit(0);
    }

    public void AggiungiFiglioSx (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio sinistro a Leaf!\n");
        System.exit(0);
    }

    public void AggiungiFiglioDx (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio destro a Leaf!\n");
        System.exit(0);
    }

    public Tree<T> Cerca (T elem) {
        return null;
    }

//--------------------------------------------------------------------------------------------------

    public Tree<T> BinarioRicercaBilanciato () {
        return this;
    }

    public void ConvertiInArray (ArrayList<T> a) {

    }

    public void AggiungiNodiDa (List<T> a) {
        System.out.println("Errore: Non puoi aggiungere figli/fratelli a Leaf!\n");
        System.exit(0);
    }

//--------------------------------------------------------------------------------------------------

    public String toString () {
        return "L";
    }

}
