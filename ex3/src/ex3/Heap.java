package ex3;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;

public class Heap {

// SUPPORT METHODS -------------------------------------------------------------

    /**
     * This method finds the parent of an element of an heap.
     * @param i: the index of the element.
     * @param size: the size of the heap.
     * @return the index of the parent of the element, -1 if the parent doesn't exist.
     * @throws IllegalArgumentException if the index of the element points out of the heap or if the size of the heap is negative.
     */

    public static int Parent (int i, int size) {
        if (i < 0 || i >= size || size < 0) {
            throw new IllegalArgumentException("Invalid index/size");
        } else {
            if (i == 0) {
                return -1;
            } else {
                if (i%2 != 0) {
                    return i/2;
                } else {
                    return (i/2) - 1;
                }
            }
        }
    }


    /**
     * This method finds the left child of an element of an heap.
     * @param i: the index of the element.
     * @param size: the size of the heap.
     * @return the index of the left child of the element, -1 if the left child doesn't exist.
     * @throws IllegalArgumentException if the index of the element points out of the heap or if the size of the heap is negative.
     */

    public static int Left (int i, int size) {
        if (i < 0 || i >= size || size < 0) {
            throw new IllegalArgumentException("Invalid index/size");
        } else {
            if ((2*i)+1 < size) {
                return (2*i)+1;
            } else {
                return -1;
            }
        }
    }


    /**
     * This method finds the right child of an element of an heap.
     * @param i: the index of the element.
     * @param size: the size of the heap.
     * @return the index of the right child of the element, -1 if the right child doesn't exist.
     * @throws IllegalArgumentException if the index of the element points out of the heap or if the size of the heap is negative.
     */

    public static int Right (int i, int size) {
        if (i < 0 || i >= size || size < 0) {
            throw new IllegalArgumentException("Invalid index/size");
        } else {
            if ((2*i)+2 < size) {
                return (2*i)+2;
            } else {
                return -1;
            }
        }
    }

// ISMAXHEAP METHODS -----------------------------------------------------------

    /**
     * This method verifies iteratively if an array is a maxheap.
     * @param a: the array to be verified.
     * @param c: the comparator to compare the elements of the array.
     * @return true if the array is a maxheap, false otherwise.
     */

    public static <T> boolean isMaxHeapIt (T[] a, Comparator<T> c) {
        int i = 0;
        boolean b = true;
        if (a.length > 1) {
            while (i < a.length && b) {
                if (Left(i, a.length) != -1) {
                    b = c.compare(a[i], a[Left(i, a.length)]) > 0;
                }
                if (Right(i, a.length) != -1 && b) {
                    b = c.compare(a[i], a[Right(i, a.length)]) > 0;
                }
                i++;
            }
        }
        return b;
    }


    /**
     * This method verifies recursively if an array is a maxheap.
     * @param a: the array to be verified.
     * @param c: the comparator to compare the elements of the array.
     * @return true if the array is a maxheap, false otherwise.
     */

    public static <T> boolean isMaxHeapRec (T[] a, Comparator<T> c) {
        if (a.length > 1) {
            return isMaxHeapRec(a, c, 0);
        } else {
            return true;
        }
    }


    /**
     * This method verifies recursively if a portion of an array is a maxheap.
     * @param a: the whole array.
     * @param c: the comparator to compare the elements of the array.
     * @param i: the index of the first element of the portion of the array.
     * @return true if the portion of the array is a maxheap, false otherwise.
     */

    private static <T> boolean isMaxHeapRec (T[] a, Comparator<T> c, int i) {
        if (Left(i, a.length) == -1 && Right(i, a.length) == -1) {
            return true;
        } else {
            if (Right(i, a.length) == -1) {
                return (c.compare(a[i], a[Left(i, a.length)]) > 0);
            } else {
                return (c.compare(a[i], a[Left(i, a.length)]) > 0) && (c.compare(a[i], a[Right(i, a.length)]) > 0) &&
                       (Heap.isMaxHeapRec(a, c, Left(i, a.length))) && (Heap.isMaxHeapRec(a, c, Right(i, a.length)));
            }
        }
    }

}
