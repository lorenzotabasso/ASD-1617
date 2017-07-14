package ex1;

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
    private boolean readCsv = true;
    private String csvPath = "/Users/simonestella/Desktop/ex1/records.csv"; // Path of the CSV file
    private int recordsToRead = 20000000;
    private boolean sortByField1 = true;
    private boolean sortByField2 = true;
    private boolean sortByField3 = true;
    // -------------------------------------------------------------------------

    public static void main (String[] args) {
        Result result = JUnitCore.runClasses(UnitTests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful());
    }

    @Test
    public void insertionSortUnitTest() {
        Comparator<Integer> btc = new BaseTypesComparator<Integer>();
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10};

        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        Sorts.insertionSort(a, btc);
        assertArrayEquals(a, expected);

        Integer[] b = {6,1,2,7,9,8,3,5,10,4};
        Sorts.insertionSort(b, btc);
        assertArrayEquals(b, expected);

        Integer[] c = {10,9,8,7,6,5,4,3,2,1};
        Sorts.insertionSort(c, btc);
        assertArrayEquals(c, expected);
        System.out.println("UnitTest of 'insertionSort' completed.");
    }

    @Test
    public void selectionSortUnitTest() {
        Comparator<Integer> btc = new BaseTypesComparator<Integer>();
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10};

        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        Sorts.selectionSort(a, btc);
        assertArrayEquals(a, expected);

        Integer[] b = {6,1,2,7,9,8,3,5,10,4};
        Sorts.selectionSort(b, btc);
        assertArrayEquals(b, expected);

        Integer[] c = {10,9,8,7,6,5,4,3,2,1};
        Sorts.selectionSort(c, btc);
        assertArrayEquals(c, expected);
        System.out.println("UnitTest of 'selectionSort' completed.");
    }

    @Test
    public void quickSortUnitTest() {
        Comparator<Integer> btc = new BaseTypesComparator<Integer>();
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10};

        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        Sorts.quickSort(a, btc);
        assertArrayEquals(a, expected);

        Integer[] b = {6,1,2,7,9,8,3,5,10,4};
        Sorts.quickSort(b, btc);
        assertArrayEquals(b, expected);

        Integer[] c = {10,9,8,7,6,5,4,3,2,1};
        Sorts.quickSort(c, btc);
        assertArrayEquals(c, expected);

        if (readCsv) {
            Record[] r = Csv.read(csvPath, ',', recordsToRead);
            if (sortByField1) {
                long start = System.currentTimeMillis();
                Sorts.quickSort(r, new Field1Comparator());
                long end = System.currentTimeMillis();
                System.out.println("Array sorted by Field1 by quickSort in " + (float)(end - start)/1000 + " seconds.");
                assertTrue(Sorts.isSorted(r, new Field1Comparator()));
            }
            if (sortByField2) {
                long start = System.currentTimeMillis();
                Sorts.quickSort(r, new Field2Comparator());
                long end = System.currentTimeMillis();
                System.out.println("Array sorted by Field2 by quickSort in " + (float)(end - start)/1000 + " seconds.");
                assertTrue(Sorts.isSorted(r, new Field2Comparator()));
            }
            if (sortByField3) {
                long start = System.currentTimeMillis();
                Sorts.quickSort(r, new Field3Comparator());
                long end = System.currentTimeMillis();
                System.out.println("Array sorted by Field3 by quickSort in " + (float)(end - start)/1000 + " seconds.");
                assertTrue(Sorts.isSorted(r, new Field3Comparator()));
            }
        }
        System.out.println("UnitTest of 'quickSort' completed.");
    }

    @Test
    public void isSortedUnitTest() {
        Comparator<Integer> btc = new BaseTypesComparator<Integer>();
        Integer[] a = {1};
        assertTrue(Sorts.isSorted(a, btc));

        Integer[] b = {4,4,4,4};
        assertTrue(Sorts.isSorted(b, btc));

        Integer[] c = {1,3,5,7,9,11,13};
        assertTrue(Sorts.isSorted(c, btc));

        Integer[] d = {2,4,6,3,9};
        assertFalse(Sorts.isSorted(d, btc));
        System.out.println("UnitTest of 'isSorted' completed.");
    }

}
