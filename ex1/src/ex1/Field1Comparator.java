package ex1;

import java.util.Comparator;

public class Field1Comparator implements Comparator<Record> {

    public int compare(Record el1, Record el2) {
        return el1.field1.compareTo(el2.field1);
    }

}
