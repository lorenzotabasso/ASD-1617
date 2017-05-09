package ex2;

import java.util.*;

public class Leaf<T extends Comparable<T>> extends Tree<T> {

    public int size() {
        return 0;
    }

    public int depth() {
        return 0;
    }

    public int depth2() {
        return 0;
    }

    public int grade () {
        return 0;
    }

    public int grade2 () {
        return 0;
    }

    public int maxGrade() {
        return 0;
    }

    public boolean binary() {
        return true;
    }

//--------------------------------------------------------------------------------------------------

    public void addBrotherR (T elem) {
        System.out.println("Errore: Non puoi aggiungere un fratello a Leaf!\n");
        System.exit(0);
    }

    public void addChildL (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio sinistro a Leaf!\n");
        System.exit(0);
    }

    public void addRightChild (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio destro a Leaf!\n");
        System.exit(0);
    }

    public Tree<T> search (T elem) {
        return null;
    }

//--------------------------------------------------------------------------------------------------

    public Tree<T> BinarySearchTree () {
        return this;
    }

    public void convertToArray (ArrayList<T> a) {

    }

    public void addNodesFrom (List<T> a) {
        System.out.println("Errore: Non puoi aggiungere figli/fratelli a Leaf!\n");
        System.exit(0);
    }

//--------------------------------------------------------------------------------------------------

    public String toString () {
        return "L";
    }

}
