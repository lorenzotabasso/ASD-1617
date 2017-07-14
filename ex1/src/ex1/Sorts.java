package ex1;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Sorts {

// INSERTIONSORT METHODS -------------------------------------------------------

    /**
     * This method sorts an array in ascending order by the insertion sort algorithm.
     * @param array: the array to be sorted.
     * @param c: the comparator to compare the elements of the array.
     */

    public static <T> void insertionSort (T[] array, Comparator<T> c){
        int i, j;
        T key;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            for (j = i - 1; j >= 0 && (c.compare(array[j], key) > 0); j--) {
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }

// SELECTIONSORT METHODS -------------------------------------------------------

    /**
     * This method sorts an array in ascending order by the selection sort algorithm.
     * @param array: the array to be sorted.
     * @param c: the comparator to compare the elements of the array.
     */

    public static <T> void selectionSort (T[] array, Comparator<T> c){
        int i, j, m;
        for (i = 0; i < array.length-1; i++) {
            m = i;
            for (j = i + 1; j < array.length; j++) {
                if ((c.compare(array[j], array[m]) < 0)) {
                    m = j;
                }
            }
            swap (array, i, m);
        }
    }

// QUICKSORT METHODS -----------------------------------------------------------

    /**
     * This method sorts an array in ascending order by the quick sort algorithm.
     * @param array: the array to be sorted.
     * @param c: the comparator to compare the elements of the array.
     */

    public static <T> void quickSort(T[] array, Comparator<T> c) {
        quickSort(array, c, 0, array.length - 1);
    }


    /**
     * This method sorts a portion of an array in ascending order by the quick sort algorithm.
     * @param array: the whole array.
     * @param c: the comparator to compare the elements of the array.
     * @param left: the index of the first element of the portion of the array.
     * @param right: the index of the last element of the portion of the array.
     */

    private static <T> void quickSort(T[] array, Comparator<T> c, int left, int right) {
        int size = right - left + 1;
        if (size < 3) { // if the size of the portion of the array is less than 3 it need at most a swap to be sorted.
            if (size == 2) {
                if (c.compare(array[left], array[right]) > 0) {
                    swap(array, left, right);
                }
            }
        } else {
            int pivotIndex;
            if (size <= 50) { // if the size of the portion of the array is less than 50 the pivot is chosen between 3 elements.
                pivotIndex = medianOf3(array, c, left, left + size/2, right);
            } else { // otherwise the pivot is chosen between 9 elements to choose the best possible one.
                pivotIndex = medianOf9(array, c, left, left + size/2, right, size);
            } // We chose 50 as limit because, after several attempts, it turned out to be the most efficient one.
            swap (array, pivotIndex, left);
            T pivot = array[left];
            int[] partitions = partitions(array, c, left, right, pivot);
            quickSort(array, c, left, partitions[0]);
            quickSort(array, c, partitions[1], right);
        }
    }


    /**
     * This method partitions a portion of an array according to a pivot.
     * The first partition contains all elements smaller than the pivot, the second one all those bigger than it.
     * @param array: the whole array.
     * @param c: the comparator to compare the elements of the array.
     * @param left: the index of the first element of the portion of the array.
     * @param right: the index of the last element of the portion of the array.
     * @param pivot: the pivot used to create the partitions.
     * @return an array containing the indices that delimit the partitions.
     */

    private static <T> int[] partitions (T[] array, Comparator<T> c, int left, int right, T pivot) {
        int i = left;
        int j = right+1;
        int p = left;
        int q = right+1;
        while (i < j) {
            while (c.compare(array[++i], pivot) < 0 && i != right) {
            }
            while (c.compare(pivot, array[--j]) < 0 && j != left) {
            } // These cycles identify the elements that need to be moved.
            if (i == j && c.compare(array[i], pivot) == 0) {
                swap(array, ++p, i);
            }
            if (i < j) {
                swap(array, i, j);
                if (c.compare(array[i], pivot) == 0) {
                    swap(array, ++p, i);
                }
                if (c.compare(array[j], pivot) == 0) {
                    swap(array, --q, j);
                }
            } // These 'if' constructs swap the elements identified with cycles
        }     // and put the elements equal to pivot at the edge of the portion of the array.

        i = j + 1;
        int k = left;
        while (k <= p) {
            swap(array, k, j--);
            k++;
        }
        k = right;
        while (k >= q) {
            swap(array, k, i++);
            k--;
        } // These cycles put the elements equal to pivot between the two partitions.

        int partitions[] = {j, i};
        return partitions;
    }


    /**
     * This method finds the median of 3 elements of an array.
     * @param array: the array.
     * @param c: the comparator to compare the elements of the array.
     * @param left: the index of the first candidate element.
     * @param middle: the index of the second candidate element.
     * @param right: the index of the third candidate element.
     * @return the index of the median.
     */

    private static <T> int medianOf3(T[] array, Comparator<T> c, int left, int middle, int right) {
        if (c.compare(array[left], array[middle]) > 0) {
            if (c.compare(array[middle], array[right]) > 0) {
                return middle;
            } else {
                if (c.compare(array[left], array[right]) > 0) {
                    return right;
                } else {
                    return left;
                }
            }
        } else {
            if (c.compare(array[left], array[right]) > 0) {
                return left;
            } else {
                if (c.compare(array[middle], array[right]) > 0) {
                    return right;
                } else {
                    return middle;
                }
            }
        }
    }


    /**
     * This method finds the median of 9 elements contained in some key points of a portion of an array.
     * @param array: the whole array.
     * @param c: the comparator to compare the elements of the array.
     * @param left: the index of the first element of the portion of the array.
     * @param middle: the index of the middle element of the portion of the array.
     * @param right: the index of the last element of the portion of the array.
     * @param size: the size of the portion of the array.
     * @return the index of the median.
     */

    private static <T> int medianOf9 (T[] array, Comparator<T> c, int left, int middle, int right, int size) {
        int blocksize = size/8;
        int m1 = medianOf3(array, c, left, left + blocksize, left + blocksize + blocksize);
        int m2 = medianOf3(array,c, middle - blocksize, middle, middle + blocksize);
        int m3 = medianOf3(array,c, right - blocksize - blocksize, right - blocksize, right);
        return medianOf3(array,c, m1, m2, m3);
    }

// SUPPORT METHODS -------------------------------------------------------------

    /**
     * This method checks if an array is sorted in ascending order.
     * @param array: the array to be checked.
     * @param c: the comparator to compare the elements of the array.
     * @return true if the array is sorted, false otherwise.
     */

    public static <T> boolean isSorted (T[] array, Comparator<T> c){
        int i = 0;
        boolean sorted = true;
        while (i < array.length-1 && sorted) {
            if (c.compare(array[i], array[i+1]) > 0) {
                sorted = false;
            }
            i++;
        }
        return sorted;
    }


    /**
     * This method swaps two elements of an array.
     * @param array: the array.
     * @param i: the index of the first element to be swapped.
     * @param j: the index of the second element to be swapped.
     */

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
