package ex1;

import java.util.Comparator;

public class BaseTypesComparator<T extends Comparable<T>> implements Comparator<T> {

    public int compare(T el1, T el2) {
        return el1.compareTo(el2);
    }

}
