package ex1;

import java.util.Comparator;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Field1Comparator implements Comparator<Record> {

    /**
     *  It compare two element (of type Field1) of the CSV file.
     * @param el1: the first element of Field1 to be compared
     * @param el2: the second element of Field1 to be compared
     * @return: an integer grather than 0 if the first element is grater than the first,
     * an integer less than 0 otherwise.
     */

    public int compare(Record el1, Record el2) {
        return el1.field1.compareTo(el2.field1);
    } // end compare

} // end class
