package ex2;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class BaseTypesComparator<T extends Comparable<T>> implements Comparator<T> {

    /**
     * This method compares two 'T' elements.
     * @param el1: the first 'T' element to be compared.
     * @param el2: the second 'T' element to be compared.
     * @return -1 if el1 < el2, 0 if el1 == el2, 1 if el1 > el2.
     */

    public int compare(T el1, T el2) {
        return el1.compareTo(el2);
    }

}
