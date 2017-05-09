package ex2;

import java.util.*;

public class Epsilon<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> parent;
    public Tree<T> brotherR;

    public Epsilon (Tree<T> parent, Tree<T> brotherR) {
        this.parent = parent;
        this.brotherR = brotherR;
    }

//--------------------------------------------------------------------------------------------------

    public int size() {
        return this.brotherR.size();
    }

    public int depth() {
        return this.brotherR.depth();
    }

    public int depth2() {
        return this.brotherR.depth2();
    }

    public int grade () {
        return this.brotherR.grade();
    }

    public int grade2 () {
        return this.brotherR.grade2();
    }

    public int maxGrade() {
        return this.brotherR.maxGrade();
    }

    public boolean binary() {
        return this.brotherR.binary();
    }

//--------------------------------------------------------------------------------------------------

    public void addBrotherR (T elem) {
        this.brotherR = new Branch<T> (this.parent, elem, new Leaf(), new Leaf());
    }

    public void addChildL (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio sinistro a Epsilon!\n");
        System.exit(0);
    }

    public void addRightChild (T elem) {
        System.out.println("Errore: Non puoi aggiungere un figlio destro a Epsilon!\n");
        System.exit(0);
    }

    public Tree<T> search (T elem) {
        return this.brotherR.search(elem);
    }

//--------------------------------------------------------------------------------------------------

    public Tree<T> BinarySearchTree () {
        return this.brotherR.BinarySearchTree();
    }

    public void convertToArray (ArrayList<T> a) {
        this.brotherR.convertToArray(a);
    }

    public void addNodesFrom (List<T> a) {
        this.brotherR.addNodesFrom(a);
    }

//--------------------------------------------------------------------------------------------------

    public String toString () {
        return "(a dx) " + brotherR;
    }

}
