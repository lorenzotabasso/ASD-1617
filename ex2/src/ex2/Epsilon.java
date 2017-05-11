package ex2;

import java.util.*;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Epsilon<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> parent;
    public Tree<T> brotherR;

    /**
     *  It inizialize each field with a value.
     * @param parent: the parent of the object Epsilon.
     * @param brotherR: the right brother of the object Epsilon.
     */

    public Epsilon (Tree<T> parent, Tree<T> brotherR) {
        this.parent = parent;
        this.brotherR = brotherR;
    } // end Epsilon

//------------------------------------------------------------------------------

    /**
     *  It recursively returns the size of Epsilon.
     * @return: recursive call to brotherR.size(),
     * because Epsilon doesn't contain anything.
     */

    public int size() {
        return this.brotherR.size();
    } // end size

    /**
     *  It recursively returns the depth of Epsilon.
     * @return: recursive call to brotherR.depth(),
     * because Epsilon doesn't contain anything.
     */

    public int depth() {
        return this.brotherR.depth();
    } // end depth

    /**
     *  It recursively returns the depth of Epsilon.
     * @return: recursive call to brotherR.depth2(),
     * because Epsilon doesn't contain anything.
     */

    public int depth2() {
        return this.brotherR.depth2();
    }// end depth2

    /**
     *  It recursively returns the grade of Epsilon.
     * @return: recursive call to brotherR.grade(),
     * because Epsilon doesn't contain anything.
     */

    public int grade () {
        return this.brotherR.grade();
    } // end grade

    /**
     *  It recursively returns the grade of Epsilon.
     * @return: recursive call to brotherR.grade2(),
     * because Epsilon doesn't contain anything.
     */

    public int grade2 () {
        return this.brotherR.grade2();
    } // end grade2

    /**
     *  It recursively returns the maximum grade of Epsilon.
     * @return: recursive call to brotherR.maxGrade(),
     * because Epsilon doesn't contain anything.
     */

    public int maxGrade() {
        return this.brotherR.maxGrade();
    } // end maxGrade

    /**
     *  It controls if Epsilon is binary (if it has two children).
     * @return: recursive call to brotherR.binary(),
     * because Epsilon doesn't contain anything.
     */

    public boolean binary() {
        return this.brotherR.binary();
    } // end binary

//--------------------------------------------------------------------------------------------------

    /**
     *  It adds a right brother to Epsilon.
     * @param elem: the value of the right brother to be inizialised.
     */

    public void addBrotherR (T elem) {
        this.brotherR = new Branch<T> (this.parent, elem, new Leaf(), new Leaf());
    } // end addBrotherR

    /**
     *  It adds a left child to Epsilon.
     * @param elem: the value of the left child to be inizialised.
     */

    public void addChildL (T elem) {
        System.out.println("Error: you can't add a left child to Epsilon!\n");
        System.exit(0);
    } // end addChildL

    /**
     *  It adds a right child to Epsilon.
     * @param elem: the value of the right child to be inizialised.
     */

    public void addChildR (T elem) {
        System.out.println("Error: you can't add a right child to Epsilon!\n");
        System.exit(0);
    } // end addChildL

    /**
     *  It search the sub-tree of the element passed throught the elem parameter.
     * @param elem: the value of the element to search.
     * @return: recursive call to brotherR.search(),
     * because Epsilon doesn't contain anything.
     */

    public Tree<T> search (T elem) {
        return this.brotherR.search(elem);
    } // end search

//--------------------------------------------------------------------------------------------------

    /**
     *  It verify if the tree is a Binary Search Tree.
     * @return: recursive call to brotherR.binarySearchTree(),
     * because Epsilon doesn't contain anything.
     */

    public Tree<T> binarySearchTree () {
        return this.brotherR.binarySearchTree();
    } // end binarySearchTree

    /**
     *  It converts the tree in an array of elements.
     * @param a: an ArrayList in which it will put the elements.
     */

    public void convertToArray (ArrayList<T> a) {
        this.brotherR.convertToArray(a);
    } // end convertToArray

    /**
     *  It adds some nodes to the Tree from a List.
     * @param a: an List that contains the elements to be added to the tree.
     */

    public void addNodesFrom (List<T> a) {
        this.brotherR.addNodesFrom(a);
    } // end addNodesFrom

//--------------------------------------------------------------------------------------------------

    /**
     *  It prints the Tree in the terminal window.
     * @return: a message to notify that he's a Epsilon,
     * and the value of his brotherR.
     */

    public String toString () {
        return "(a dx) " + brotherR;
    } // end toString

} // end class
