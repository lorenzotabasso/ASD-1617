package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class EdgeComparator implements Comparator<Edge> {

    /**
     * This method compares two edges by the weight.
     * @param edge1: the first edge to be compared.
     * @param edge2: the second edge to be compared.
     * @return -1 if edge1 < edge2, 0 if edge1 == edge2, 1 if edge1 > edge2.
     */

    public int compare(Edge edge1, Edge edge2) {
        if (edge1.weight == edge2.weight) {
            return 0;
        } else {
            if (edge1.weight < edge2.weight) {
                return -1;
            } else {
                return +1;
            }
        }
    }

}
