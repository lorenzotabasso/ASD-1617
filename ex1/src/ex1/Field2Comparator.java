package ex1;

import java.util.Comparator;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Field2Comparator implements Comparator<Record> {

    /**
     *  It compare two element (of type Field2) of the CSV file.
     * @param el1: the first element of Field2 to be compared
     * @param el2: the second element of Field2 to be compared
     * @return: an integer grather than 0 if the first element is grater than the first,
     * an integer less than 0 otherwise.
     */

    public int compare(Record el1, Record el2) {
        if (el1.field2 == el2.field2) {
            return 0;
        } else {
            if (el1.field2 < el2.field2) {
                return -1;
            } else {
                return +1;
            } // end if
        } // end if
    } // end compare

} // end class
