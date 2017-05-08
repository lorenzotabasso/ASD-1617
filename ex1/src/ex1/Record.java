package ex1;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Record {

    public int id;
    public String field1;
    public int field2;
    public float field3;

    /**
     *  It inizialize each field with a value.
     * @param id: the element id of the object Record
     * @param f1: the element Field1 of the object Record
     * @param f2: the element Field2 of the object Record
     * @param f3: the element Field3 of the object Record
     */

    public Record (int id, String f1, int f2, float f3) {
        this.id = id;
        this.field1 = f1;
        this.field2 = f2;
        this.field3 = f3;
    } // end Record

    /**
     *  It prints a line with all the values that it reads.
     * @return: a String with all the values that it reads.
     */

    public String toString() {
        return "[" + id + " , " + field1 + " , " + field2 + " , " + field3 + "]\n";
    } // end toString
}
