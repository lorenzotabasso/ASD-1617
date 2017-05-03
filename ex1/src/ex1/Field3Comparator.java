package ex1;

import java.util.Comparator;

public class Field3Comparator implements Comparator<Record> {

    public int compare(Record el1, Record el2) {
        if (el1.field3 == el2.field3) {
            return 0;
        } else {
            if (el1.field3 < el2.field3) {
                return -1;
            } else {
                return +1;
            }
        }
    }

}
