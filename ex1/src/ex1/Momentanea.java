import java.util.Arrays;

public class Momentanea {

    public static void main(String[] args) {
        try {
            //
            // Sorts Sort = new Sorts(new BaseTypesComparator());
            // Integer[] a = {3,5,1,4,2};
            // System.out.println(Arrays.toString(a));
            // System.out.println("Sorted? " + Sort.isSorted(a) + "\n");
            // Sort.insertionSort(a);
            // System.out.println(Arrays.toString(a));
            // System.out.println("Sorted? " + Sort.isSorted(a) + "\n");

            Record[] record = CSVReader.read("/Users/simonestella/Desktop/ex1/ordered_array_sample_file.csv", ",");
            Sorts Sort = new Sorts(new Field1Comparator());

            int i = 0;
            while (i < 5) {
                System.out.print(record[i]);
                i++;
            }

            Sort.insertionSort(record);
            System.out.println();

            i = 0;
            while (i < 5) {
                System.out.print(record[i]);
                i++;
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

}
