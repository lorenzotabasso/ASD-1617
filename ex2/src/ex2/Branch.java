package ex2;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Branch<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> parent;
    public T elem;
    public Tree<T> sibling;
    public Tree<T> child;
    public Comparator<T> c;

    /**
     * Constructor of a 'Branch' object.
     * @param parent: the value for the attribute 'parent'.
     * @param elem: the value for the attribute 'elem'.
     * @param sibling: the value for the attribute 'sibling'.
     * @param child: the value for the attribute 'child'.
     * @param c: the value for the attribute 'c'.
     */

    public Branch (Tree<T> parent, T elem, Tree<T> sibling, Tree<T> child, Comparator<T> c) {
        this.parent = parent;
        this.elem = elem;
        this.sibling = sibling;
        this.child = child;
        this.c = c;
    }

// SECONDARY METHODS -----------------------------------------------------------

    /**
    * This method identifies the cardinality of a tree.
    * @return the cardinality of the tree.
    */

    public int cardinality() {
        return 1 + this.sibling.cardinality() + this.child.cardinality();
    }


    /**
    * These methods identify the height of a tree.
    * @return the height of the tree.
    */

    public int height() {
        return 1 + this.child.height2();
    }

    public int height2() {
        int h1 = this.height();
        int h2 = this.sibling.height2();
        if (h1 > h2) {
            return h1;
        } else {
            return h2;
        }
    }


    /**
    * These methods identify the degree of a node of a tree.
    * @return the degree of the node of the tree.
    */

    public int degree () {
        return this.child.degree2();
    }

    public int degree2 () {
        return 1 + this.sibling.degree2();
    }


    /**
    * This method identifies the maximum degree of a tree.
    * @return the maximum degree of the tree.
    */

    public int maxDegree() {
        int d1 = this.degree();
        int d2 = this.child.maxDegree();
        int d3 = this.sibling.maxDegree();
        if (d1 >= d3 && d1 >= d2) {
            return d1;
        } else {
            if (d3 >= d1 && d3 >= d2) {
                return d3;
            } else {
                return d2;
            }
        }
    }


    /**
    * This method checks if a tree is binary.
    * @return true if the tree is binary, false otherwise.
    */

    public boolean isBinary() {
        return (this.degree() <= 2 && this.sibling.isBinary() && this.child.isBinary());
    }

//  MAIN METHODS ---------------------------------------------------------------

    /**
    * This method adds a sibling to a node of a tree.
    * @param elem: the element to be inserted in the sibling.
    */

    public void addSibling (T elem) {
        this.sibling = new Branch<T> (this.parent, elem, new Leaf<T>(), new Leaf<T>(), c);
    }


    /**
    * This method adds a child to a node of a tree.
    * @param elem: the element to be inserted in the child.
    */

    public void addChild (T elem) {
        this.child = new Branch<T> (this, elem, new Leaf<T>(), new Leaf<T>(), c);
    }


    /**
     * This method finds the node of a tree that contains a specific element.
     * @param elem: the element that the node must contain.
     * @return a pointer to the node found, null if that node doesn't exist.
     */

    public Tree<T> findNode (T elem) {
        if (c.compare(this.elem, elem) == 0) {
            return this;
        } else {
            Tree<T> t = this.sibling.findNode(elem);
            if (t == null) {
                t = this.child.findNode(elem);
            }
            return t;
        }
    }

// BINARYSEARCHTREE METHODS ----------------------------------------------------

    /**
     * This method creates a balanced binary search tree from another tree.
     * @return the balanced binary search tree created.
     */

    public Tree<T> binarySearchTree () {
        ArrayList<T> a = new ArrayList<T>();
        this.toArrayList(a);
        Collections.sort(a, c); // Based on MergeSort, Complexity: O(nlogn).
        Tree<T> t = new Branch<T>(new Leaf<T>(), a.get(a.size()/2), new Leaf<T>(), new Leaf<T>(), c);
        t.fromArrayList(a);
        return t;
    }


    /**
     * This method converts a tree into an ArrayList.
     * @param a: the ArrayList in which to store the tree.
     */

    public void toArrayList (ArrayList<T> a) {
        a.add(this.elem);
        this.sibling.toArrayList(a);
        this.child.toArrayList(a);
    }


    /**
     * This method converts a sorted List into a balanced binary search tree.
     * @param a: the List used to create the balanced binary search tree.
     */

    public void fromArrayList (List<T> a) {
        if (a.size() > 1) {
            Tree<T> t = this.findNode(a.get(a.size()/2));
            List<T> left = a.subList(0, a.size()/2);
            List<T> right = a.subList ((a.size()/2)+1, a.size());
            t.addChild(left.get(left.size()/2));
            t = this.findNode(left.get(left.size()/2));
            if (right.size() > 0) {
                t.addSibling(right.get(right.size()/2));
            }
            this.fromArrayList(left);
            this.fromArrayList(right);
        }
    }

// OTHER METHODS ---------------------------------------------------------------

    /**
     * This method converts a tree into a string.
     * @return the string obtained.
     */

    public String toString () {
        if (sibling instanceof Branch && child instanceof Branch) {
            return "" + elem + " | sbl(" + elem + "):" + sibling + " | chl(" + elem + "):" + child;
        } else {
            if (sibling instanceof Leaf && child instanceof Leaf) {
                return "" + elem;
            } else {
                if (sibling instanceof Leaf) {
                    return "" + elem + " | chl(" + elem + "):" + child;
                } else {
                    return "" + elem + " | sbl(" + elem + "):" + sibling;
                }
            }
        }
    }

}
