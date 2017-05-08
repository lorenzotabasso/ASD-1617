
public class Tests {

    public static void main(String[] args) {
        UnionFind<Integer> a = new UnionFind<Integer>();
        a.AddSet(5);
        a.AddSet(3);
        a.AddSet(9);
        a.AddSet(1);
        a.UnionSet(1,3);
        a.UnionSet(5,9);
        a.PrintSet(1);
        a.PrintSet(9);
        a.UnionSet(3,5);
        a.PrintSet(9);
    }

}
