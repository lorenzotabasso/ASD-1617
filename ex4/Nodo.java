
public class Nodo<T extends Comparable<T>> {

    public Nodo<T> padre;
    public T elem;
    public int rank;

    public Nodo (T elem) {
        this.padre = this;
        this.elem = elem;
        this.rank = 0;
    }

}
