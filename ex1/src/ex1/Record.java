package ex1;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Record {

    public String field1;
    public int field2;
    public float field3;

    /**
     * Constructor of a 'Record' object.
     * @param field1: the value for the attribute 'field1'.
     * @param field2: the value for the attribute 'field2'.
     * @param field3: the value for the attribute 'field3'.
     */

    public Record (String field1, int field2, float field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }


    /**
     * This method converts a 'Record' object into a string.
     * @return the string obtained.
     */

    public String toString() {
        return "[" + field1 + " , " + field2 + " , " + field3 + "]\n";
    }

}
