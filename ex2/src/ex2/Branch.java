package ex2;

import java.util.*;

public class Branch<T extends Comparable<T>> extends Tree<T> {

    public Tree<T> parent;
    public T value;
    public Tree<T> brotherR;
    public Tree<T> childL;

    public Branch (Tree<T> parent, T value, Tree<T> brotherR, Tree<T> childL) {
        this.parent = parent;
        this.value = value;
        this.brotherR = brotherR;
        this.childL = childL;
    }

//--------------------------------------------------------------------------------------------------

    public int size() {
        return 1 + this.brotherR.size() + this.childL.size();
    }

    public int depth() {
        return 1 + this.childL.depth2();
    }

    public int depth2() {
        if (this.depth() > this.brotherR.depth2()) {
            return this.depth();
        } else {
            return this.brotherR.depth2();
        }
    }

    public int grade () {
        return this.childL.grade2();
    }

    public int grade2 () {
        return 1 + this.brotherR.grade2();
    }

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
            }
        }
    }

    public boolean binary() {
        return (this.grade() <= 2 && this.brotherR.binary() && this.childL.binary());
    }

//--------------------------------------------------------------------------------------------------

    public void addBrotherR (T elem) {
        this.brotherR = new Branch<T> (this.parent, elem, new Leaf(), new Leaf());
    }

    public void addChildL (T elem) {
        this.childL = new Branch<T> (this, elem, new Leaf(), new Leaf());
    }

    public void addRightChild (T elem) {
        this.childL = new Epsilon<T> (this, new Branch<T> (this, elem, new Leaf(), new Leaf()));
    }

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
        }
    }

//--------------------------------------------------------------------------------------------------

    public Tree<T> BinarySearchTree () {
        ArrayList<T> a = new ArrayList<T> (this.size());
        this.convertToArray(a);
        Collections.sort(a);
        Tree<T> r = new Branch (new Leaf(), a.get(a.size()/2), new Leaf(), new Leaf());
        r.addNodesFrom(a);
        return r;
    }

    public void convertToArray (ArrayList<T> a) {
        a.add(this.value);
        this.brotherR.convertToArray(a);
        this.childL.convertToArray(a);
    }

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
            }
            this.addNodesFrom(sx);
            this.addNodesFrom(dx);
        }
    }

//--------------------------------------------------------------------------------------------------

    public String toString () {
        return "" + value + ", fr." + value + " è " + brotherR + ", fi." + value + " è " + childL;
    }

}
