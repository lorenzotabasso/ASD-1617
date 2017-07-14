package ex3;

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
    public void ParentUnitTest() {
        Integer[] h = {15,8,9,3,2,4};
        assertTrue(Heap.Parent(0, h.length) == -1);
        assertEquals(h[Heap.Parent(1, h.length)], h[0]);
        assertEquals(h[Heap.Parent(2, h.length)], h[0]);
        assertEquals(h[Heap.Parent(3, h.length)], h[1]);
        assertEquals(h[Heap.Parent(4, h.length)], h[1]);
        assertEquals(h[Heap.Parent(5, h.length)], h[2]);
        System.out.println("UnitTest of 'Parent' completed.");
    }

    @Test
    public void LeftUnitTest() {
        Integer[] h = {15,8,9,3,2,4};
        assertEquals(h[Heap.Left(0, h.length)], h[1]);
        assertEquals(h[Heap.Left(1, h.length)], h[3]);
        assertEquals(h[Heap.Left(2, h.length)], h[5]);
        assertTrue(Heap.Left(3, h.length) == -1);
        assertTrue(Heap.Left(4, h.length) == -1);
        assertTrue(Heap.Left(5, h.length) == -1);
        System.out.println("UnitTest of 'Left' completed.");
    }

    @Test
    public void RightUnitTest() {
        Integer[] h = {15,8,9,3,2,4};
        assertEquals(h[Heap.Right(0, h.length)], h[2]);
        assertEquals(h[Heap.Right(1, h.length)], h[4]);
        assertTrue(Heap.Right(2, h.length) == -1);
        assertTrue(Heap.Right(3, h.length) == -1);
        assertTrue(Heap.Right(4, h.length) == -1);
        assertTrue(Heap.Right(5, h.length) == -1);
        System.out.println("UnitTest of 'Right' completed.");
    }

    @Test
    public void isMaxHeapItUnitTest() {
        Comparator<Integer> btc = new BaseTypesComparator<Integer>();
        Integer[] h1 = {1};
        assertTrue(Heap.isMaxHeapIt(h1, btc));

        Integer[] h2 = {15,8,9,3,2,4};
        assertTrue(Heap.isMaxHeapIt(h2, btc));

        Integer[] h3 = {15,8,9,10,2,4};
        assertFalse(Heap.isMaxHeapIt(h3, btc));

        Integer[] h4 = {2,3,4,8,9,15};
        assertFalse(Heap.isMaxHeapIt(h4, btc));
        System.out.println("UnitTest of 'isMaxHeapIt' completed.");
    }

    @Test
    public void isMaxHeapRecUnitTest() {
        Comparator<Integer> btc = new BaseTypesComparator<Integer>();
        Integer[] h1 = {1};
        assertTrue(Heap.isMaxHeapRec(h1, btc));

        Integer[] h2 = {15,8,9,3,2,4};
        assertTrue(Heap.isMaxHeapRec(h2, btc));

        Integer[] h3 = {15,8,9,10,2,4};
        assertFalse(Heap.isMaxHeapRec(h3, btc));

        Integer[] h4 = {2,3,4,8,9,15};
        assertFalse(Heap.isMaxHeapRec(h4, btc));
        System.out.println("UnitTest of 'isMaxHeapRec' completed.");
    }

}
