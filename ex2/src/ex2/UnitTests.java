package ex2;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class UnitTests {

    // SETTINGS ----------------------------------------------------------------
    private String csvPath1 = "/Users/simonestella/Desktop/ex2/multywaytree_1.csv";
    private String csvPath2 = "/Users/simonestella/Desktop/ex2/multywaytree_2.csv";
    private String csvPath3 = "/Users/simonestella/Desktop/ex2/multywaytree_3.csv";
    // -------------------------------------------------------------------------

    public static void main (String[] args) {
        Result result = JUnitCore.runClasses(UnitTests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful());
    }

    @Test
    public void cardinalityUnitTest() {
        Tree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(), 5, new Leaf<Integer>(), new Leaf<Integer>(), new BaseTypesComparator<Integer>());
        assertTrue (t1.cardinality() == 1);

        t1.addChild(3);
        assertTrue (t1.cardinality() == 2);

        Tree<Integer> t2 = t1.findNode(3);
        t2.addSibling(8);
        assertTrue (t1.cardinality() == 3);

        Tree<Integer> t3 = Csv.read(csvPath3, ",");
        assertTrue (t3.cardinality() == 8);
        System.out.println("UnitTest of 'cardinality' completed.");
    }

    @Test
    public void heightUnitTest() {
        Tree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(), 5, new Leaf<Integer>(), new Leaf<Integer>(), new BaseTypesComparator<Integer>());
        assertTrue (t1.height() == 1);

        t1.addChild(3);
        assertTrue (t1.height() == 2);

        Tree<Integer> t2 = t1.findNode(3);
        t2.addSibling(8);
        assertTrue (t1.height() == 2);

        Tree<Integer> t3 = Csv.read(csvPath3, ",");
        assertTrue (t3.height() == 4);
        System.out.println("UnitTest of 'height' completed.");
    }

    @Test
    public void degreeUnitTest() {
        Tree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(), 5, new Leaf<Integer>(), new Leaf<Integer>(), new BaseTypesComparator<Integer>());
        assertTrue (t1.degree() == 0);

        t1.addChild(3);
        assertTrue (t1.degree() == 1);

        Tree<Integer> t2 = t1.findNode(3);
        t2.addSibling(8);
        assertTrue (t1.degree() == 2);

        Tree<Integer> t3 = Csv.read(csvPath3, ",");
        assertTrue (t3.maxDegree() == 3);
        System.out.println("UnitTest of 'degree' completed.");
    }

    @Test
    public void isBinaryUnitTest() {
        Tree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(), 5, new Leaf<Integer>(), new Leaf<Integer>(), new BaseTypesComparator<Integer>());
        assertTrue (t1.isBinary());

        t1.addChild(3);
        assertTrue (t1.isBinary());

        Tree<Integer> t2 = t1.findNode(3);
        t2.addSibling(8);
        assertTrue (t1.isBinary());

        t2 = t1.findNode(8);
        t2.addSibling(15);
        assertFalse (t1.isBinary());

        Tree<Integer> t3 = Csv.read(csvPath3, ",");
        assertFalse (t3.isBinary());
        System.out.println("UnitTest of 'isBinary' completed.");
    }

    @Test
    public void findNodeUnitTest() {
        Tree<Integer> t1 = new Branch<Integer>(new Leaf<Integer>(), 5, new Leaf<Integer>(), new Leaf<Integer>(), new BaseTypesComparator<Integer>());
        t1.addChild(3);
        Tree<Integer> t2 = t1.findNode(5);
        assertSame(t1, t2);

        t2 = t1.findNode(3);
        assertNotNull(t2);

        t2 = t1.findNode(7);
        assertNull(t2);
        System.out.println("UnitTest of 'findNode' completed.");
    }

    @Test
    public void binarySearchTreeUnitTest() {
        Tree<Integer> t1 = Csv.read(csvPath3, ",");
        Tree<Integer> t2 = t1.binarySearchTree();
        assertTrue (t1.cardinality() == t2.cardinality());
        assertTrue(t2.isBinary());
        assertTrue((t2.toString()).contains("7"));
        assertTrue((t2.toString()).contains("chl(7):3"));
        assertTrue((t2.toString()).contains("sbl(3):12"));
        assertTrue((t2.toString()).contains("chl(3):2"));
        assertTrue((t2.toString()).contains("sbl(2):4"));
        assertTrue((t2.toString()).contains("chl(2):1"));
        assertTrue((t2.toString()).contains("chl(12):9"));
        assertTrue((t2.toString()).contains("sbl(9):20"));
        Tree<Integer> s = t2.findNode(3);
        int LeftTreeHeight = s.height();
        s = t2.findNode(12);
        int RightTreeHeight = s.height();
        assertTrue ((LeftTreeHeight - RightTreeHeight) == -1 || (LeftTreeHeight - RightTreeHeight) == 0 || (LeftTreeHeight - RightTreeHeight) == 1); // To assert that the bst is balanced.

        t1 = Csv.read(csvPath1, ",");
        t2 = t1.binarySearchTree();
        assertTrue (t1.cardinality() == t2.cardinality());
        assertTrue(t2.isBinary());

        t1 = Csv.read(csvPath2, ",");
        t2 = t1.binarySearchTree();
        assertTrue (t1.cardinality() == t2.cardinality());
        assertTrue(t2.isBinary());
        System.out.println("UnitTest of 'binarySearchTree' completed.");
    }

}
