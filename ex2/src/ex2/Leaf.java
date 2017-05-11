package ex2;

import java.util.*;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Leaf<T extends Comparable<T>> extends Tree<T> {

    /**
     *  It recursively returns the size of Leaf.
     * @return: 0, because Leaf doesn't have any children.
     */

    public int size() {
        return 0;
    } // end size

    /**
     *  It recursively returns the depth of Leaf.
     * @return: 0, because Leaf doesn't have any children.
     */

    public int depth() {
        return 0;
    } // end depth

    /**
     *  It recursively returns the depth of Leaf.
     * @return: 0, because Leaf doesn't have any children.
     */

    public int depth2() {
        return 0;
    } // end depth2

    /**
     *  It recursively returns the grade of Leaf.
     * @return: 0, because Leaf doesn't have any children.
     */

    public int grade () {
        return 0;
    } // end grade

    /**
     *  It recursively returns the grade of Leaf.
     * @return: 0, because Leaf doesn't have any children.
     */

    public int grade2 () {
        return 0;
    } // end grade2

    /**
     *  It recursively returns the maximum grade of Leaf.
     * @return: 0, because Leaf doesn't have any children.
     */

    public int maxGrade() {
        return 0;
    } // end maxGrade

    /**
     *  It controls if Leaf is binary (if it has two children).
     * @return: true, because Leaf doesn't have any children.
     */

    public boolean binary() {
        return true;
    } // end binary

//------------------------------------------------------------------------------

    /**
     *  It adds a right brother to Leaf.
     * @param elem: the value of the right brother to be inizialised.
     */

    public void addBrotherR (T elem) {
        System.out.println("Error: you can't add a right brother to Leaf!\n");
        System.exit(0);
    } // end addBrotherR

    /**
     *  It adds a left child to Leaf.
     * @param elem: the value of the left child to be inizialised.
     */

    public void addChildL (T elem) {
        System.out.println("Error: you can't add a left child to Leaf!\n");
        System.exit(0);
    } // end addChildL

    /**
     *  It adds a right child to Leaf.
     * @param elem: the value of the right child to be inizialised.
     */

    public void addChildR (T elem) {
        System.out.println("Error: you can't add a right child to Leaf!\n");
        System.exit(0);
    } // end addChildR

    /**
     *  It search the sub-tree of the element passed throught the elem parameter.
     * @param elem: the value of the element to search.
     * @return: null, because Leaf doesn't have any children.
     */

    public Tree<T> search (T elem) {
        return null;
    } // end search

//------------------------------------------------------------------------------

    /**
     *  It verify if the tree is a Binary Search Tree.
     * @return: Leaf itself.
     */

    public Tree<T> binarySearchTree () {
        return this;
    } // end binarySearchTree

    /**
     *  It converts the tree in an array of elements.
     * @param a: an ArrayList in which it will put the elements.
     */

    public void convertToArray (ArrayList<T> a) {

    } // end convertToArray

    /**
     *  It adds some nodes to the Tree from a List.
     * @param a: an List that contains the elements to be added to the tree.
     */

    public void addNodesFrom (List<T> a) {
        System.out.println("Error: you can't add children or brothers to Leaf!\n");
        System.exit(0);
    } // end addNodesFrom

//------------------------------------------------------------------------------

    /**
     *  It prints the tree in the terminal window.
     * @return: a message to notify that he's a Leaf,
     */

    public String toString () {
        return "L";
    } // end toString

} // end class
