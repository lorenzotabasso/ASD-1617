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

    private static String csv1 = "/Users/simonestella/Desktop/definitivo ex2/multywaytree_1.csv";
    private static String csv2 = "/Users/simonestella/Desktop/definitivo ex2/multywaytree_2.csv";
    private static String csv3 = "/Users/simonestella/Desktop/definitivo ex2/multywaytree_3.csv";

    public static void main (String[] args) {

        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful() + "\n");

    }

    @Test
    public void dimensione() {
        System.out.println("Testing dimensione ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        int x = t.dimensione();
        Tree<Integer> s = t.Cerca(2);
        s.AggiungiFiglioSx(99);
        int y = t.dimensione();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void profondita() {
        System.out.println("Testing profondità ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        int x = t.profondita();
        Tree<Integer> s = t.Cerca(12);
        s.AggiungiFiglioSx(99);
        int y = t.profondita();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void grado() {
        System.out.println("Testing grado ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        Tree<Integer> s1 = t.Cerca(3);
        int x = s1.grado();
        Tree<Integer> s2 = t.Cerca(12);
        s2.AggiungiFratelloDx(99);
        int y = s1.grado();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void maxgrado() {
        System.out.println("Testing maxgrado ...");
        Tree<Integer> t = CSV.read(csv3, ",");
        int x = t.maxgrado();
        Tree<Integer> s = t.Cerca(20);
        s.AggiungiFratelloDx(99);
        int y = t.maxgrado();
        assertTrue(y == x + 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void BinarioRicercaBilanciato() {
        System.out.println("Testing BinarioRicercaBilanciato ...");
        Tree<Integer> t1 = CSV.read(csv3, ",");
        Tree<Integer> t2 = t1.BinarioRicercaBilanciato();
        assertTrue(t2.binario());
        assertTrue((t2.toString()).contains("7"));
        assertTrue((t2.toString()).contains("fi.7 è 3"));
        assertTrue((t2.toString()).contains("fr.3 è 12"));
        assertTrue((t2.toString()).contains("fi.3 è 2"));
        assertTrue((t2.toString()).contains("fr.2 è 4"));
        assertTrue((t2.toString()).contains("fi.2 è 1"));
        assertTrue((t2.toString()).contains("fi.12 è 9"));
        assertTrue((t2.toString()).contains("fr.9 è 20"));
        Tree<Integer> s = t2.Cerca(3);
        int x = s.profondita();
        s = t2.Cerca(12);
        int y = s.profondita();
        assertTrue((x - y) == -1 || (x - y) == 0 || (x - y) == 1);
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

}
