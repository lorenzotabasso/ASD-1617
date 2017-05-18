//package ex3;

import java.util.*;

public class CompleteTree <T extends Comparable<T>> {

    public ArrayList<T> a;

    public CompleteTree () {
        a = new ArrayList<T>();
    }

    public CompleteTree (T[] x) {
        a = new ArrayList<T> (Arrays.asList(x));
    }

//------------------------------------------------------------------------------

    public int getIndexP(int i) throws Exception {
        if (i < 0 || i >= this.size()) {
            throw new Exception("Invalid index: " + i);
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

    public int getIndexL (int i) throws Exception {
        if (i < 0 || i >= this.size()) {
            throw new Exception("Invalid index: " + i);
        } else {
            if (this.size() == 1) {
                return -1;
            } else {
                if (i == 0) {
                    return 1;
                } else {
                    if ((2*i)+1 < this.size()) {
                        return (2*i)+1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    public int getIndexR (int i) throws Exception {
        if (i < 0 || i >= this.size()) {
            throw new Exception("Invalid index: " + i);
        } else {
            if (this.size() == 1) {
                return -1;
            } else {
                if (i == 0 && this.size() == 2) {
                    return -1;
                }
                if (i == 0 && this.size() > 2) {
                    return 2;
                } else {
                    if ((2*i)+2 < this.size()) {
                        return (2*i)+2;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    public T getValue (int i) throws Exception {
        if (i < 0 || i >= this.size()) {
            throw new Exception("Invalid index: " + i);
        } else {
            return a.get(i);
        }
    }

    public int size () {
        return a.size();
    }

//------------------------------------------------------------------------------

    public void add (T elem) throws Exception {
        a.add(elem);
    }

//------------------------------------------------------------------------------

    public boolean isMaxHeapRec () throws Exception {
        return this.isMaxHeapRec(0);
    }

    public boolean isMaxHeapRec (int i) throws Exception {
        if (this.getIndexL(i) == -1 && this.getIndexR(i) == -1) {
            return true;
        } else {
            if (this.getIndexR(i) == -1) {
                return (this.getValue(i).compareTo(this.getValue(this.getIndexL(i))) > 0);
            } else {
                return (this.getValue(i).compareTo(this.getValue(this.getIndexL(i))) > 0)
                        && (this.getValue(i).compareTo(this.getValue(this.getIndexR(i))) > 0)
                        && isMaxHeapRec(this.getIndexL(i))
                        && isMaxHeapRec(this.getIndexR(i));
            }
        }
    }

    public boolean isMaxHeapIt () throws Exception {
        int i = 0;
        boolean b = true;
        if (this.size() != 1) {
            while (i < this.size()-1 && b) {
                if (this.getIndexL(i) != -1) {
                    if (this.getValue(i).compareTo(this.getValue(this.getIndexL(i))) < 0) {
                        b = false;
                    }
                }
                if (this.getIndexR(i) != -1) {
                    if (this.getValue(i).compareTo(this.getValue(this.getIndexR(i))) < 0) {
                        b = false;
                    }
                }
                i++;
            }
        }
        return b;
    }

//------------------------------------------------------------------------------

    public String toString () {
        return "" + a;
    }
}
