package ex2;

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

    private static String csv1 = "/Users/lorenzotabasso/Dropbox/Progetti Uni/ASD/Esercizio 2/3.1 Lorenzo - ENG/multywaytree_1.csv";
    private static String csv2 = "/Users/lorenzotabasso/Dropbox/Progetti Uni/ASD/Esercizio 2/3.1 Lorenzo - ENG/multywaytree_2.csv";
    private static String csv3 = "/Users/lorenzotabasso/Dropbox/Progetti Uni/ASD/Esercizio 2/3.1 Lorenzo - ENG/multywaytree_3.csv";

    public static void main (String[] args) {

        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful() + "\n");

    }

    @Test
    public void size() {
        System.out.println("Testing size ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        int x = t.size();
        Tree<Integer> s = t.search(2);
        s.addChildL(99);
        int y = t.size();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void depth() {
        System.out.println("Testing depth ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        int x = t.depth();
        Tree<Integer> s = t.search(12);
        s.addChildL(99);
        int y = t.depth();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void grade() {
        System.out.println("Testing grade ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        Tree<Integer> s1 = t.search(3);
        int x = s1.grade();
        Tree<Integer> s2 = t.search(12);
        s2.addBrotherR(99);
        int y = s1.grade();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void maxGrade() {
        System.out.println("Testing maxGrade ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        int x = t.maxGrade();
        Tree<Integer> s = t.search(20);
        s.addBrotherR(99);
        int y = t.maxGrade();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void BinarySearchTree() {
        System.out.println("Testing BinarySearchTree ...");
        Tree<Integer> t1 = CSV.read(csv3, ",");
        Tree<Integer> t2 = t1.BinarySearchTree();
        assertTrue(t2.binary());
        assertTrue((t2.toString()).contains("7"));
        assertTrue((t2.toString()).contains("fi.7 è 3"));
        assertTrue((t2.toString()).contains("fr.3 è 12"));
        assertTrue((t2.toString()).contains("fi.3 è 2"));
        assertTrue((t2.toString()).contains("fr.2 è 4"));
        assertTrue((t2.toString()).contains("fi.2 è 1"));
        assertTrue((t2.toString()).contains("fi.12 è 9"));
        assertTrue((t2.toString()).contains("fr.9 è 20"));
        Tree<Integer> s = t2.search(3);
        int x = s.depth();
        s = t2.search(12);
        int y = s.depth();
        assertTrue((x - y) == -1 || (x - y) == 0 || (x - y) == 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

}
