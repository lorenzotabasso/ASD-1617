// package ex1;

public class Record {

    public int id;
    public String field1;
    public int field2;
    public float field3;

    public Record (int id, String f1, int f2, float f3) {
        this.id = id;
        this.field1 = f1;
        this.field2 = f2;
        this.field3 = f3;
    }

    public String toString() {
        return id + " " + field1 + " " + field2 + " " + field3 + "\n";
    }
}
