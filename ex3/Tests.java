//package ex3;

public class Tests {

    public static void main(String[] args) throws Exception {

        Integer[] x = {2,4,7,9,11,5};
        CompleteTree<Integer> t = new MaxHeap<Integer>();
        t.add(16);
        t.add(18);
        t.add(25);
        t.add(7);
        t.add(15);
        t.add(19);
        t.add(29);
        t.add(40);

        System.out.println(t);
        System.out.println(t.isMaxHeapIt());

    }

}
