import java.util.*;

public class UnionFind<T extends Comparable<T>> {

    Map<T, Nodo<T>> GroupOfSet = new HashMap<T, Nodo<T>>();

    public void AddSet (T k) {
        GroupOfSet.put(k, new Nodo<T>(k));
    }

    public Nodo<T> FindSet (T k) {
        Nodo<T> n = GroupOfSet.get(k);
        if (n != n.padre) {
            n.padre = FindSet(n.padre.elem);
        }
        return n.padre;
    }

    public void UnionSet (T x, T y) {
        this.Link(FindSet(x), FindSet(y));
    }

    public void Link (Nodo<T> x, Nodo<T> y) {
        if (x.rank > y.rank) {
            y.padre = x;
        } else {
            x.padre = y;
            if (x.rank == y.rank) {
                y.rank++;
            }
        }
    }

    public void PrintSet (T k) {
        System.out.print("Set containing " + k + ": ");
        Nodo<T> n = this.FindSet(k);
        Set<T> s = GroupOfSet.keySet();
        Object[] a = s.toArray(new Object[s.size()]);
        int i = 0;
        while (i < a.length) {
            if (n == this.FindSet((T)a[i])) {
                System.out.print(a[i] + " ");
            }
            i++;
        }
        System.out.println();
    }

}
