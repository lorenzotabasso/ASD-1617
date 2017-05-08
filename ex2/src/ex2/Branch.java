package ex2;

import java.util.*;

public class Branch<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> padre;
    public T valore;
    public Tree<T> fratelloDx;
    public Tree<T> figlioSx;

    public Branch (Tree<T> padre, T valore, Tree<T> fratelloDx, Tree<T> figlioSx) {
        this.padre = padre;
        this.valore = valore;
        this.fratelloDx = fratelloDx;
        this.figlioSx = figlioSx;
    }

//--------------------------------------------------------------------------------------------------

    public int dimensione() {
        return 1 + this.fratelloDx.dimensione() + this.figlioSx.dimensione();
    }

    public int profondita() {
        return 1 + this.figlioSx.profondita2();
    }

    public int profondita2() {
        if (this.profondita() > this.fratelloDx.profondita2()) {
            return this.profondita();
        } else {
            return this.fratelloDx.profondita2();
        }
    }

    public int grado () {
        return this.figlioSx.grado2();
    }

    public int grado2 () {
        return 1 + this.fratelloDx.grado2();
    }

    public int maxgrado() {
        int a = this.grado();
        int b = this.figlioSx.maxgrado();
        int c = this.fratelloDx.maxgrado();
        if (a >= c && a >= b) {
            return a;
        } else {
            if (c >= a && c >= b) {
                return c;
            } else {
                return b;
            }
        }
    }

    public boolean binario() {
        return (this.grado() <= 2 && this.fratelloDx.binario() && this.figlioSx.binario());
    }

//--------------------------------------------------------------------------------------------------

    public void AggiungiFratelloDx (T elem) {
        this.fratelloDx = new Branch<T> (this.padre, elem, new Leaf(), new Leaf());
    }

    public void AggiungiFiglioSx (T elem) {
        this.figlioSx = new Branch<T> (this, elem, new Leaf(), new Leaf());
    }

    public void AggiungiFiglioDx (T elem) {
        this.figlioSx = new Epsilon<T> (this, new Branch<T> (this, elem, new Leaf(), new Leaf()));
    }

    public Tree<T> Cerca (T elem) {
        if (this.valore.equals(elem)) {
            return this;
        } else {
            Tree<T> m = this.fratelloDx.Cerca(elem);
            if (m != null) {
                return m;
            }
            m = this.figlioSx.Cerca(elem);
            if (m != null) {
                return m;
            }
            return m;
        }
    }

//--------------------------------------------------------------------------------------------------

    public Tree<T> BinarioRicercaBilanciato () {
        ArrayList<T> a = new ArrayList<T> (this.dimensione());
        this.ConvertiInArray(a);
        Collections.sort(a);
        Tree<T> r = new Branch (new Leaf(), a.get(a.size()/2), new Leaf(), new Leaf());
        r.AggiungiNodiDa(a);
        return r;
    }

    public void ConvertiInArray (ArrayList<T> a) {
        a.add(this.valore);
        this.fratelloDx.ConvertiInArray(a);
        this.figlioSx.ConvertiInArray(a);
    }

    public void AggiungiNodiDa (List<T> a) {
        if (a.size() > 1) {
            Tree<T> s;
            s = this.Cerca(a.get(a.size()/2));
            List<T> sx = a.subList(0, a.size()/2);
            List<T> dx = a.subList ((a.size()/2)+1, a.size());
            s.AggiungiFiglioSx(sx.get(sx.size()/2));
            s = this.Cerca(sx.get(sx.size()/2));
            if (dx.size() > 0) {
                s.AggiungiFratelloDx(dx.get(dx.size()/2));
            }
            this.AggiungiNodiDa(sx);
            this.AggiungiNodiDa(dx);
        }
    }

//--------------------------------------------------------------------------------------------------

    public String toString () {
        return "" + valore + ", fr." + valore + " è " + fratelloDx + ", fi." + valore + " è " + figlioSx;
    }

}
