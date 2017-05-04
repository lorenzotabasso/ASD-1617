package ex1;

import java.util.Comparator;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 * @param <T>: type of the elements to be compared
 */

public class BaseTypesComparator<T extends Comparable<T>> implements Comparator<T> {

    /**
     *  It compares two elements using compareTo method of Java
     * @param el1: the first element to be compared
     * @param el2: the second element to be compared
     * @return: an integer grather than 0 if the first element is grater than the first,
     * an integer less than 0 otherwise.
     */

    public int compare(T el1, T el2) {
        return el1.compareTo(el2);
    } // end compare

} // end class
