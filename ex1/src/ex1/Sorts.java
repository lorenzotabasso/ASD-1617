package ex1;

import java.util.Comparator;

public class Sorts {

    private Comparator c;

    public Sorts (Comparator c) {
        this.c = c;
    }

//  CHECK IF AN ARRAY IS SORTED ------------------------------------------------

    public <T> boolean isSorted (T[] array){
        int i = 0;
        boolean result = true;
        while (i < array.length-1 && result) {
            if (c.compare(array[i], array[i+1]) > 0) {
                result = false;
            }
            i++;
        }
        return result;
    }


//  INSERTION SORT -------------------------------------------------------------

    public <T> void insertionSort (T[] array){
        long ti = System.currentTimeMillis();
        long tf;
        System.out.println("Sorting array by insertionSort ...");

        int i;
        int j = 0;
        T key;
        for (i = 1; i < array.length; j = i, i++) {
            key = array[i];
            while (j >= 0 && (c.compare(array[j], key) > 0)) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }

        tf = System.currentTimeMillis();
        System.out.println("Array sorted in " + (float)(tf - ti)/1000 + " seconds.\n");
    }


//  SELECTION SORT -------------------------------------------------------------

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
                }
            }
            tmp = array[i];
            array[i] = array[m];
            array[m] = tmp;
        }

        tf = System.currentTimeMillis();
        System.out.println("Array sorted in " + (float)(tf - ti)/1000 + " seconds.\n");
    }


//  QUICK SORT -----------------------------------------------------------------

    public <T> void quickSort(T[] array) {
        long ti = System.currentTimeMillis();
        long tf;
        System.out.println("Sorting array by quickSort ...");

        quickSort(array, 0, array.length-1);

        tf = System.currentTimeMillis();
        System.out.println("Array sorted in " + (float)(tf - ti)/1000 + " seconds.\n");
    }

    private <T> void quickSort(T[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
    }

    private <T> int partition(T[] array, int left, int right) {
        int i = left, j = right;
        T tmp;
        T pivot = array[(left + right) / 2];
        while (i <= j) {
            while (c.compare(array[i], pivot) < 0) {
                i++;
            }
            while (c.compare(array[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

}
