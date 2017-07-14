package ex2;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public abstract class Tree <T> {

// SECONDARY METHODS -----------------------------------------------------------
    public abstract int cardinality();
    public abstract int height();
    public abstract int height2();
    public abstract int degree();
    public abstract int degree2();
    public abstract int maxDegree();
    public abstract boolean isBinary();

//  MAIN METHODS ---------------------------------------------------------------
    public abstract void addSibling (T elem);
    public abstract void addChild (T elem);
    public abstract Tree<T> findNode (T elem);

// BINARYSEARCHTREE METHODS ----------------------------------------------------
    public abstract Tree<T> binarySearchTree();
    public abstract void toArrayList (ArrayList<T> a);
    public abstract void fromArrayList (List<T> a);
}
