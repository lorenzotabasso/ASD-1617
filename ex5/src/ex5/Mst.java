package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Mst {

    /**
     * This method identifies the mst of an oriented graph by the Kruscal algorithm.
     * @param g: the oriented graph.
     * @return the mst of the oriented graph.
     */

    public static OrientedGraph Kruscal (OrientedGraph g) {
        OrientedGraph mst = new OrientedGraph();
        UnionFind<String> uf = new UnionFind<String>();

        // Creation of a set in 'uf' for each vertex of 'g'.
        Object[] a = g.adjacencyList.keySet().toArray();
        int i = 0;
        while (i < a.length) {
            uf.MakeSet((String)a[i]);
            i++;
        }

        // Creation of a list containing all the edges of 'g' sorted by weight in ascending order.
        ArrayList<Edge> l = g.allEdges();
        Collections.sort(l, new EdgeComparator()); // Based on MergeSort, Complexity: O(nlogn)

        // Creation of the mst using Union and Find.
        while (!l.isEmpty() && uf.SetsNumber > 1) {
            Edge e = l.get(0);
            l.remove(0);
            if (uf.Find(e.sourceVertex) != uf.Find(e.destVertex)) {
                mst.add(e.sourceVertex, e.destVertex, e.weight);
                uf.Union(e.sourceVertex, e.destVertex);
            }
        }

        return mst;
    }

}
