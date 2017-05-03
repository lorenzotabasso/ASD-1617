package ex1;

import java.util.Arrays;
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

    private Sorts BaseTypes = new Sorts(new BaseTypesComparator());
    private Sorts Field1 = new Sorts(new Field1Comparator());
    private Sorts Field2 = new Sorts(new Field2Comparator());
    private Sorts Field3 = new Sorts(new Field3Comparator());
    private String csv_small = "/Users/simonestella/Desktop/definitivo/caseautomobilistiche.csv";
    private String csv_big = "/Users/simonestella/Desktop/definitivo/records.csv";

    public static void main (String[] args) {
        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful() + "\n");
    }

    @Test
    public void isSorted() {
        System.out.println("----------------------------------------------");
        System.out.println("Testing isSorted ...");
        Integer[] a = {4,2,5,1,3};
        assertFalse(BaseTypes.isSorted(a));
        Integer[] b = {1,2,3,4,5};
        assertTrue(BaseTypes.isSorted(b));
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void insertionSort(){
        System.out.println("Testing insertionSort ...\n");
        Record[] records = CSV.read(csv_small, ",");
        Field1.insertionSort(records);
        assertTrue(Field1.isSorted(records));
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void selectionSort(){
        System.out.println("Testing selectionSort ...\n");
        Record[] records = CSV.read(csv_small, ",");
        Field1.selectionSort(records);
        assertTrue(Field1.isSorted(records));
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

    @Test
    public void quickSort(){
        System.out.println("Testing quickSort ...\n");
        Record[] records = CSV.read(csv_big, ",");
        Field1.quickSort(records);
        assertTrue(Field1.isSorted(records));
        System.out.println("Test Completed!");
        System.out.println("----------------------------------------------");
    }

}
