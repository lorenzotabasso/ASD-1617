package ex1;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Field2Comparator implements Comparator<Record> {

    /**
     * This method compares two 'Record' objects by the attribute 'field2'.
     * @param r1: the first 'Record' object to be compared.
     * @param r2: the second 'Record' object to be compared.
     * @return -1 if r1 < r2, 0 if r1 == r2, 1 if r1 > r2.
     */

    public int compare(Record r1, Record r2) {
        if (r1.field2 == r2.field2) {
            return 0;
        } else {
            if (r1.field2 < r2.field2) {
                return -1;
            } else {
                return +1;
            }
        }
    }

}
