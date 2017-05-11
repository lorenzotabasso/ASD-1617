package ex2;

import java.util.*;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public abstract class Tree <T> {

    public abstract int size();
    public abstract int depth();
    public abstract int depth2();
    public abstract int grade();
    public abstract int grade2();
    public abstract int maxGrade();
    public abstract boolean binary();

    public abstract void addBrotherR (T elem);
    public abstract void addChildL (T elem);
    public abstract void addChildR (T elem);
    public abstract Tree<T> search (T elem);

    public abstract Tree<T> binarySearchTree();
    public abstract void convertToArray (ArrayList<T> a);
    public abstract void addNodesFrom (List<T> a);

} // end class
