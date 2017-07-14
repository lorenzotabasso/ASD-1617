package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Edge {

    public String sourceVertex;
    public float weight;
    public String destVertex;

    /**
     * Constructor of a 'Edge' object.
     * @param vertex1: the value for the attribute 'sourceVertex'.
     * @param vertex2: the value for the attribute 'destVertex'.
     * @param weight: the value for the attribute 'weight'.
     */

    public Edge (String vertex1, String vertex2, float weight) {
        this.sourceVertex = vertex1;
        this.weight = weight;
        this.destVertex = vertex2;
    }


    /**
     * This method converts a 'Edge' object into a string.
     * @return the string obtained.
     */

    public String toString () {
        return destVertex + " (" + weight/1000 + "km)";
    }

}
