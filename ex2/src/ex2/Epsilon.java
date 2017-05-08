package ex2;

import java.util.*;

public class Epsilon<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> padre;
    public Tree<T> fratelloDx;

    public Epsilon (Tree<T> padre, Tree<T> fratelloDx) {
        this.padre = padre;
        this.fratelloDx = fratelloDx;
    }

//--------------------------------------------------------------------------------------------------

    public int dimensione() {
        return this.fratelloDx.dimensione();
    }

    public int profondita() {
        return this.fratelloDx.profondita();
    }

    public int profondita2() {
        return this.fratelloDx.profondita2();
    }

    public int grado () {
        return this.fratelloDx.grado();
    }

    public int grado2 () {
        return this.fratelloDx.grado2();
    }

    public int maxgrado() {
        return this.fratelloDx.maxgrado();
    }

    public boolean binario() {
        return this.fratelloDx.binario();
    }

//--------------------------------------------------------------------------------------------------

    public void AggiungiFratelloDx (T elem) {
        this.fratelloDx = new Branch<T> (this.padre, elem, new Leaf(), new Leaf());
    }

    public void AggiungiFiglioSx (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio sinistro a Epsilon!\n");
        System.exit(0);
    }

    public void AggiungiFiglioDx (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio destro a Epsilon!\n");
        System.exit(0);
    }

    public Tree<T> Cerca (T elem) {
        return this.fratelloDx.Cerca(elem);
    }

//--------------------------------------------------------------------------------------------------

    public Tree<T> BinarioRicercaBilanciato () {
        return this.fratelloDx.BinarioRicercaBilanciato();
    }

    public void ConvertiInArray (ArrayList<T> a) {
        this.fratelloDx.ConvertiInArray(a);
    }

    public void AggiungiNodiDa (List<T> a) {
        this.fratelloDx.AggiungiNodiDa(a);
    }

//--------------------------------------------------------------------------------------------------

    public String toString () {
        return "(a dx) " + fratelloDx;
    }

}
