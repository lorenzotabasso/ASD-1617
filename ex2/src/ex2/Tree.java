package ex2;

import java.util.*;

public abstract class Tree <T> {

    public abstract int dimensione();
    public abstract int profondita();
    public abstract int profondita2();
    public abstract int grado();
    public abstract int grado2();
    public abstract int maxgrado();
    public abstract boolean binario();

    public abstract void AggiungiFratelloDx (T elem);
    public abstract void AggiungiFiglioSx (T elem);
    public abstract void AggiungiFiglioDx (T elem);
    public abstract Tree<T> Cerca (T elem);

    public abstract Tree<T> BinarioRicercaBilanciato();
    public abstract void ConvertiInArray (ArrayList<T> a);
    public abstract void AggiungiNodiDa (List<T> a);

}
