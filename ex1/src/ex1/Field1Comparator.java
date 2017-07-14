package ex1;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Field1Comparator implements Comparator<Record> {

    /**
     * This method compares two 'Record' objects by the attribute 'field1'.
     * @param r1: the first 'Record' object to be compared.
     * @param r2: the second 'Record' object to be compared.
     * @return -1 if r1 < r2, 0 if r1 == r2, 1 if r1 > r2.
     */

    public int compare(Record r1, Record r2) {
        return r1.field1.compareTo(r2.field1);
    }

}
