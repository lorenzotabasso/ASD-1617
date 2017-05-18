package ex3;

//GESTIRE LE ECCEZIONI CON LE CATCH

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    public static CompleteTree<Integer> t;
    public static Integer[] x = {9,5,2,7,2,3,3,7,8};

    public static void main (String[] args) throws Exception {

        if (args.length == 0) {
                System.out.println("Invalid parameters!\nRequested: <type of tree>");
                System.exit(0);
        }

        int i = 0;
        if (args[0].compareTo("CompleteTree") == 0) {
            t = new CompleteTree<>(x);
        } else {
            if (args[0].compareTo("MaxHeap") == 0) {
                t = new MaxHeap<>();
                while (i < x.length) {
                    t.add(x[i]);
                    i++;
                }
            } else {
                if (args[0].compareTo("MinHeap") == 0) {
                    t = new MinHeap<>();
                    while (i < x.length) {
                        t.add(x[i]);
                        i++;
                    }
                } else {
                    System.out.println("Invalid parameters!\nRequested: <type of tree>");
                    System.exit(0);
                }
            }
        }

        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful() + "\n");

    }

    @Test
    public void size() {

    }

}

// public class Tests {
//
//     public static void main(String[] args) throws Exception {
//
//         Integer[] x = {2,4,7,9,11,5};
//         CompleteTree<Integer> t = new MaxHeap<Integer>();
//         t.add(16);
//         t.add(18);
//         t.add(25);
//         t.add(7);
//         t.add(15);
//         t.add(19);
//         t.add(29);
//         t.add(40);
//
//         System.out.println(t);
//         System.out.println(t.isMaxHeapIt());
//
//     }
//
// }
