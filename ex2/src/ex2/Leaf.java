package ex2;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Leaf<T extends Comparable<T>> extends Tree<T> {

// SECONDARY METHODS -----------------------------------------------------------

    public int cardinality() {
        return 0;
    }

    public int height() {
        return 0;
    }

    public int height2() {
        return 0;
    }

    public int degree () {
        return 0;
    }

    public int degree2 () {
        return 0;
    }

    public int maxDegree() {
        return 0;
    }

    public boolean isBinary() {
        return true;
    }

//  MAIN METHODS ---------------------------------------------------------------

    public void addSibling (T elem) {
        throw new NullPointerException ("Not possibile to add a sibling to a Leaf.");
    }

    public void addChild (T elem) {
        throw new NullPointerException ("Not possibile to add a child to a Leaf.");
    }

    public Tree<T> findNode (T elem) {
        return null;
    }

// BINARYSEARCHTREE METHODS ----------------------------------------------------

    public Tree<T> binarySearchTree () {
        return this;
    }

    public void toArrayList (ArrayList<T> a) {

    }

    public void fromArrayList (List<T> a) {
        throw new NullPointerException ("Not possibile to add a sibling/child to a Leaf.");
    }

// OTHER METHODS ---------------------------------------------------------------

    public String toString () {
        return "L";
    }

}
