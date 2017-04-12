// package ex1;

import java.util.Comparator;

public class Sorts {

    private Comparator c;

    public Sorts (Comparator c) {
        this.c = c;
    }

//  INSERTION SORT -------------------------------------------------------------

    public <T> void insertionSort (T[] array) {
        insertionSortRec (array, 0);
    }

    private <T> void insertionSortRec (T[] array, int i)  {
        if (i < array.length) {
            insertEl (array, i);
            insertionSortRec (array, i+1);
        }
    }

    private <T> void insertEl (T[] array, int i) {
        if (i >= 1 && (c.compare(array[i], array[i-1]) < 0)) {
            swap (array, i, i-1);
            insertEl (array, i-1);
        }
    }

    private <T> void swap (T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

//  CHECK IF AN ARRAY IS SORTED ------------------------------------------------

    public <T> boolean isSorted (T[] array){
        return isSortedRec(array, 0);
    }

    private <T> boolean isSortedRec (T[] array, int i){
        if (i == array.length-1) {
            return true;
        } else {
            return isSortedRec(array, i+1) && (c.compare(array[i], array[i+1]) < 0);
        }
    }

}
