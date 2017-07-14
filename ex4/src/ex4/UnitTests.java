package ex4;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class UnitTests {

    public static void main (String[] args) {
        Result result = JUnitCore.runClasses(UnitTests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful());
    }

    @Test
    public void MakeSetUnitTest() {
        UnionFind<Integer> uf = new UnionFind<Integer>();
        assertTrue(uf.Sets.isEmpty());

        uf.MakeSet(5);
        assertTrue(uf.Sets.size() == 1 && uf.SetsNumber == 1);
        assertTrue(uf.Sets.containsKey(5));

        uf.MakeSet(8);
        assertTrue(uf.Sets.size() == 2 && uf.SetsNumber == 2);
        assertTrue(uf.Sets.containsKey(8));
        System.out.println("UnitTest of 'MakeSet' completed.");
    }

    @Test
    public void FindUnitTest() {
        UnionFind<Integer> uf = new UnionFind<Integer>();
        uf.MakeSet(5);
        uf.MakeSet(8);
        assertSame(uf.Find(5), uf.Sets.get(5));
        assertSame(uf.Find(8), uf.Sets.get(8));

        uf.Union(5, 8);
        assertSame(uf.Find(5), uf.Find(8));
        System.out.println("UnitTest of 'Find' completed.");
    }

    @Test
    public void UnionUnitTest() {
        UnionFind<Integer> uf = new UnionFind<Integer>();
        uf.MakeSet(5);
        uf.MakeSet(8);
        uf.MakeSet(1);
        uf.MakeSet(3);
        assertTrue(uf.SetsNumber == 4);

        uf.Union(1,8);
        uf.Union(3,5);
        assertTrue(uf.SetsNumber == 2);
        assertSame(uf.Find(1), uf.Find(8));
        assertSame(uf.Find(3), uf.Find(5));
        assertNotSame(uf.Find(1), uf.Find(3));
        assertNotSame(uf.Find(1), uf.Find(5));
        assertNotSame(uf.Find(8), uf.Find(3));
        assertNotSame(uf.Find(8), uf.Find(5));

        uf.Union(1,5);
        assertTrue(uf.SetsNumber == 1);
        assertSame(uf.Find(1), uf.Find(3));
        assertSame(uf.Find(1), uf.Find(5));
        assertSame(uf.Find(1), uf.Find(8));
        assertSame(uf.Find(3), uf.Find(5));
        assertSame(uf.Find(3), uf.Find(8));
        assertSame(uf.Find(5), uf.Find(8));
        System.out.println("UnitTest of 'Union' completed.");
    }

}
