package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class OrientedGraph {

    public Map<String, ArrayList<Edge>> adjacencyList = new HashMap<String, ArrayList<Edge>>();
    int VerticesNumber = 0;
    int EdgesNumber = 0;

// SECONDARY METHODS -----------------------------------------------------------

    /**
     * This method groups all the edges of an oriented graph in an ArrayList.
     * @return the ArrayList containing all the edges of the oriented graph.
     */

    public ArrayList<Edge> allEdges () {
        ArrayList<Edge> l = new ArrayList<Edge>();
        Iterator<Map.Entry<String, ArrayList<Edge>>> it = adjacencyList.entrySet().iterator();
        while (it.hasNext()) {
            l.addAll(it.next().getValue());
        }
        return l;
    }


    /**
     * This method identifies the weight of an oriented graph.
     * @return the weight of the oriented graph.
     */

    public float weight() {
        float weight = 0;
        ArrayList<Edge> l = this.allEdges();
        int i = 0;
        while (i < l.size()) {
            weight = weight + l.get(i).weight;
            i++;
        }
        return weight;
    }

// MAIN METHODS ----------------------------------------------------------------

    /**
     * This method adds a vertex to an oriented graph.
     * @param vertex: the vertex to be added in the oriented graph.
     */

    public void add (String vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<Edge>());
            VerticesNumber++;
        }
    }


    /**
     * This method adds a couple of vertices and the relative edge in an oriented graph.
     * @param vertex1: the first vertex to be added in the oriented graph.
     * @param vertex2: the second vertex to be added in the oriented graph.
     * @param weight: the weight of the relative edge.
     */

    public void add (String vertex1, String vertex2, float weight) {
        if (adjacencyList.containsKey(vertex1)) {
            ArrayList<Edge> l = adjacencyList.get(vertex1);
            l.add(new Edge(vertex1, vertex2, weight));
            EdgesNumber++;
        } else {
            ArrayList<Edge> l = new ArrayList<Edge>();
            l.add(new Edge(vertex1, vertex2, weight));
            adjacencyList.put(vertex1, l);
            VerticesNumber++;
            EdgesNumber++;
        }
        this.add(vertex2);
    }

// OTHER METHODS ---------------------------------------------------------------

    /**
     * This method prints an oriented graph.
     */

    public void print () {
        Object[] a = adjacencyList.keySet().toArray();
        int i = 0;
        while (i < a.length) {
            System.out.println(a[i] + ": " + adjacencyList.get(a[i]));
            i++;
        }
    }

}
