package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class UnionFind<T extends Comparable<T>> {

    Map<T, Node<T>> Sets = new HashMap<T, Node<T>>();
    int SetsNumber = 0;

// MAIN METHODS ----------------------------------------------------------------

    /**
     * This method creates a new set.
     * @param k: the key to be inserted in the set.
     * @throws IllegalStateException if a set containing that key already exists.
     */

    public void MakeSet (T k) {
        Node<T> n = Sets.get(k);
        if (n == null) {
            Sets.put(k, new Node<T>(k));
            SetsNumber++;
        } else {
            throw new IllegalStateException("Set containing " + k + " already exists");
        }
    }


    /**
     * This method finds the set that contains a specific key.
     * @param k: the key that the set must contain.
     * @return a pointer to the parent node of the set.
     * @throws NullPointerException if the set containing that key doesn't exist.
     */

    public Node<T> Find (T k) {
        Node<T> n = Sets.get(k);
        if (n == null) {
            throw new NullPointerException("Set containing " + k + " doesn't exist");
        } else {
            if (n != n.parent) {
                n.parent = Find(n.parent.elem); // First optimization: Path Compression
            }
            return n.parent;
        }
    }


    /**
     * This method links two different sets.
     * @param k1: the key that the first set must contain.
     * @param k2: the key that the second set must contain.
     */

    public void Union (T k1, T k2) {
        Node<T> n1 = this.Find(k1);
        Node<T> n2 = this.Find(k2);
        if (n1 != n2) {
            this.Link(n1, n2);
            SetsNumber--;
        }
    }


    /**
     * This method links two nodes by the rank.
     * @param n1: the first node to be linked.
     * @param n2: the second node to be linked.
     */

    public void Link (Node<T> n1, Node<T> n2) {
        if (n1.rank > n2.rank) { // Second optimization: Union by Rank
            n2.parent = n1;
        } else {
            n1.parent = n2;
            if (n1.rank == n2.rank) {
                n2.rank++;
            }
        }
    }

// OTHER METHODS ---------------------------------------------------------------

    /**
     * This method prints a set.
     * @param k: the key that the set must contain.
     */

    public void Print (T k) {
        Node<T> n = this.Find(k);
        Object[] a = Sets.keySet().toArray();
        int i = 0;
        System.out.print("Set containing " + k + ": ");
        while (i < a.length) {
            if (n == this.Find((T)a[i])) {
                System.out.print(a[i] + " ");
            }
            i++;
        }
        System.out.println();
    }

}
