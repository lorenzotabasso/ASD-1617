package ex1;

import java.util.Comparator;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class Sorts {

    private Comparator c;

    /**
     *  It inizialize a comparator.
     * @param c: a comparator, used for compare during sorting.
     */

    public Sorts (Comparator c) {
        this.c = c;
    } // end Sorts

//  CHECK IF AN ARRAY IS SORTED ------------------------------------------------

    /**
     *  It checks if the object "array" is sorted.
     * @param array: an array of object of type T.
     * @return: true if and only if array is actually sorted, false otherwise.
     */

    public <T> boolean isSorted (T[] array){
        int i = 0;
        boolean result = true;
        while (i < array.length-1 && result) {
            if (c.compare(array[i], array[i+1]) > 0) {
                result = false;
            } // end if
            i++;
        } // end while
        return result;
    } // end isSorted


//  INSERTION SORT -------------------------------------------------------------

    /**
     *  It orders the parameter using insertionSort algorithm. It uses some
     *  timestamp features.
     * @param array: an array of object of type T to be sorted.
     */

    public <T> void insertionSort (T[] array){
        long ti = System.currentTimeMillis(); //setting initial time
        long tf; // final time
        System.out.println("Sorting array by insertionSort ...");

        int i;
        int j = 0;
        T key;
        for (i = 1; i < array.length; j = i, i++) {
            key = array[i];
            while (j >= 0 && (c.compare(array[j], key) > 0)) {
                array[j+1] = array[j];
                j--;
            } // end while
            array[j+1] = key;
        } // end for

        tf = System.currentTimeMillis(); // assigning final time
        System.out.println("Array sorted in " + (float)(tf - ti)/1000 + " seconds.\n");
    } // end insertionSort


//  SELECTION SORT -------------------------------------------------------------

    /**
     *  It orders the parameter using selectionSort algorithm. It uses some
     *  timestamp features.
     * @param array: an array of object of type T to be sorted.
     */

    public <T> void selectionSort (T[] array){
        long ti = System.currentTimeMillis();
        long tf;
        System.out.println("Sorting array by selectionSort ...");

        int i, j, m;
        T tmp;
        for (i = 0; i < array.length-1; i++) {
            m = i;
            for (j = i+1; j < array.length; j++) {
                if ((c.compare(array[j], array[m]) < 0)) {
                    m = j;
                } // end if
            } // end for
            tmp = array[i];
            array[i] = array[m];
            array[m] = tmp;
        } // end for

        tf = System.currentTimeMillis();
        System.out.println("Array sorted in " + (float)(tf - ti)/1000 + " seconds.\n");
    } // end selectionSort


//  QUICK SORT -----------------------------------------------------------------

    /**
     *  It calls recursively the method quickSort, wich orders
     * the parameter "array" using quickSort algorithm.
     * It implements some timestamp features.
     * @param array: an array of object of type T to be sorted.
     */

    public <T> void quickSort(T[] array) {
        long ti = System.currentTimeMillis();
        long tf;
        System.out.println("Sorting array by quickSort ...");

        quickSort(array, 0, array.length-1);

        tf = System.currentTimeMillis();
        System.out.println("Array sorted in " + (float)(tf - ti)/1000 + " seconds.\n");
    } // end quickSort

    /**
     *  It orders the parameter "arr" using quickSort algorithm.
     * @param array: an array of object of type T to be sorted.
     * @param left: index of the left part of the array.
     * @param right: index of the right part of the array.
     */

    private <T> void quickSort(T[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        } // end if
        if (index < right) {
            quickSort(array, index, right);
        } // end if
    } // end quickSort

    /**
     *  It divides the array into partitions, as definition of quickSort algorithm.
     * @param array: an array of object of type T to be sorted.
     * @param left: index of the left part of the array.
     * @param right: index of the right part of the array.
     * @return: left index of the partition.
     */

    private <T> int partition(T[] array, int left, int right) {
        int i = left, j = right;
        T tmp;
        T pivot = array[(left + right) / 2];
        while (i <= j) {
            while (c.compare(array[i], pivot) < 0) {
                i++;
            } // end while
            while (c.compare(array[j], pivot) > 0) {
                j--;
            } // end while
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            } // end if
        } // end while
        return i;
    } // end partition

} // end class
