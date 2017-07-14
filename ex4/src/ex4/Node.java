package ex4;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Node<T extends Comparable<T>> {

    public Node<T> parent;
    public T elem;
    public int rank;

    /**
      * Constructor of a 'Node' object.
      * @param elem: the value for the attribute 'elem'.
      */

    public Node (T elem) {
        this.parent = this;
        this.elem = elem;
        this.rank = 0;
    }

}
