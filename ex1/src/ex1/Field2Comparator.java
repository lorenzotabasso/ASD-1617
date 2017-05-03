package ex1;

import java.util.Comparator;

public class Field2Comparator implements Comparator<Record> {

    public int compare(Record el1, Record el2) {
        if (el1.field2 == el2.field2) {
            return 0;
        } else {
            if (el1.field2 < el2.field2) {
                return -1;
            } else {
                return +1;
            }
        }
    }

}
