package ex3;

import java.util.*;

public class MinHeap <T extends Comparable<T>> extends CompleteTree<T> {

    public MinHeap () {
        super();
    }

//------------------------------------------------------------------------------

    public void add (T elem) throws Exception {
        a.add(elem);
        this.move(this.size() - 1);
    }

    public void move (int i) throws Exception {
        if (i != 0) {
            if (this.getValue(i).compareTo(this.getValue(this.getIndexP(i))) < 0) {
                T tmp = this.getValue(this.getIndexP(i));
                a.set(this.getIndexP(i), this.getValue(i));
                a.set(i, tmp);
                this.move(this.getIndexP(i));
            }
        }
    }

}
