package ex2;

import java.util.*;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Branch<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> parent;
    public T value;
    public Tree<T> brotherR;
    public Tree<T> childL;

    /**
     *  It inizialize each field with a value.
     * @param parent: the parent of the object Branch.
     * @param value: the value of the object Branch to be inizialized.
     * @param brotherR: the right brother of the object Branch.
     * @param childL: the left child of the object Branch.
     */

    public Branch (Tree<T> parent, T value, Tree<T> brotherR, Tree<T> childL) {
        this.parent = parent;
        this.value = value;
        this.brotherR = brotherR;
        this.childL = childL;
    } // end branch

//------------------------------------------------------------------------------

    /**
     *  It recursively returns the size of the Branch.
     * @return: integer value of the size of the branch.
     */

    public int size() {
        return 1 + this.brotherR.size() + this.childL.size();
    } // end size

    /**
     *  It recursively returns the depth of the Branch. It calls depth2().
     * @return: integer value of the depth of the branch.
     */

    public int depth() {
        return 1 + this.childL.depth2();
    } // end depth

    /**
     *  It recursively returns the depth of the Branch. It calls depth().
     * @return: integer value of the depth of the branch.
     */

    public int depth2() {
        if (this.depth() > this.brotherR.depth2()) {
            return this.depth();
        } else {
            return this.brotherR.depth2();
        } // end if
    } // end depth2

    /**
     *  It recursively returns the grade of the Branch. It calls grade2().
     * @return: integer value of the grade of the branch.
     */

    public int grade () {
        return this.childL.grade2();
    } // end grade

    /**
     *  It recursively returns the grade of the Branch. It calls grade().
     * @return: integer value of the grade of the branch.
     */

    public int grade2 () {
        return 1 + this.brotherR.grade2();
    } // end grade2

    /**
     *  It returns the maximum grade of the Branch.
     * @return: integer value of the maximum grade of the branch.
     */

    public int maxGrade() {
        int a = this.grade();
        int b = this.childL.maxGrade();
        int c = this.brotherR.maxGrade();
        if (a >= c && a >= b) {
            return a;
        } else {
            if (c >= a && c >= b) {
                return c;
            } else {
                return b;
            } // end if
        } // end if
    } // end maxGrade

    /**
     *  It controls if Branch is binary (if it has two children).
     * @return: true if and only if Branch has two children, false otherwise
     */

    public boolean binary() {
        return (this.grade() <= 2 && this.brotherR.binary() && this.childL.binary());
    } // end binary

//------------------------------------------------------------------------------

    /**
     *  It adds a right brother to Branch.
     * @param elem: the value of the right brother to be inizialised.
     */

    public void addBrotherR (T elem) {
        this.brotherR = new Branch<T> (this.parent, elem, new Leaf(), new Leaf());
    } // end addBrotherR

    /**
     *  It adds a left child to Branch.
     * @param elem: the value of the left child to be inizialised.
     */

    public void addChildL (T elem) {
        this.childL = new Branch<T> (this, elem, new Leaf(), new Leaf());
    } // end addChildL

    /**
     *  It adds a right child to Branch.
     * @param elem: the value of the right child to be inizialised.
     */

    public void addChildR (T elem) {
        this.childL = new Epsilon<T> (this, new Branch<T> (this, elem, new Leaf(), new Leaf()));
    } // addChildR

    /**
     *  It search the sub-tree of the element passed throught the elem parameter.
     * @param elem: the value of the element to search.
     * @return: the sub-tree m containing the element.
     */

    public Tree<T> search (T elem) {
        if (this.value.equals(elem)) {
            return this;
        } else {
            Tree<T> m = this.brotherR.search(elem);
            if (m != null) {
                return m;
            }
            m = this.childL.search(elem);
            if (m != null) {
                return m;
            }
            return m;
        } // end if
    } // end search

//------------------------------------------------------------------------------

    /**
     *  It verify if the tree is a Binary Search Tree.
     * @return: a new tree r, the same of the "old" tree,
     * but ordered as a Binary Search Tree.
     */

    public Tree<T> binarySearchTree () {
        ArrayList<T> a = new ArrayList<T> (this.size());
        this.convertToArray(a);
        Collections.sort(a);
        Tree<T> r = new Branch (new Leaf(), a.get(a.size()/2), new Leaf(), new Leaf());
        r.addNodesFrom(a);
        return r;
    } // end binarySearchTree

    /**
     *  It converts the tree in an array of elements.
     * @param a: an ArrayList in which it will put the elements.
     */

    public void convertToArray (ArrayList<T> a) {
        a.add(this.value);
        this.brotherR.convertToArray(a);
        this.childL.convertToArray(a);
    } // end convertToArray

    /**
     *  It adds some nodes to the Tree from a List.
     * @param a: an List that contains the elements to be added to the tree.
     */

    public void addNodesFrom (List<T> a) {
        if (a.size() > 1) {
            Tree<T> s;
            s = this.search(a.get(a.size()/2));
            List<T> sx = a.subList(0, a.size()/2);
            List<T> dx = a.subList ((a.size()/2)+1, a.size());
            s.addChildL(sx.get(sx.size()/2));
            s = this.search(sx.get(sx.size()/2));
            if (dx.size() > 0) {
                s.addBrotherR(dx.get(dx.size()/2));
            } // end if
            this.addNodesFrom(sx);
            this.addNodesFrom(dx);
        } // end if
    } // end addNodesFrom

//------------------------------------------------------------------------------

    /**
     *  It prints the Tree in the terminal window.
     * @return: a string which describes all the tree.
     */

    public String toString () {
        return "" + value + ", fr." + value + " è " + brotherR + ", fi." + value + " è " + childL;
    } // end toString

} // end class
