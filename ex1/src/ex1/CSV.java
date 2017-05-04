package ex1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author: Malgaroli, Stella, Tabasso
 */

public class CSV {

    /**
     *  It reads one line (Record) of the CSV file.
     * @param csvfile: the path of the file to be read
     * @param fieldDividedBy: the type of separators of the fields
     * @return: the object Record just read.
     * @throws Exception if and only if while reading it finds an error.
     */

    public static Record[] read (String csvfile, String fieldDividedBy) {
        try {
            String[] file = csvfile.split("/");
            System.out.println("Reading " + file[file.length-1] + " ...");
            long ti = System.currentTimeMillis();

            BufferedReader br = new BufferedReader(new FileReader(csvfile));
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                row++;
            } // end while
            br.close();

            Record[] record = new Record[row];
            br = new BufferedReader(new FileReader(csvfile));
            int i = 0;
            String[] el;
            while ((line = br.readLine()) != null) {
                el = line.split(fieldDividedBy);
                record[i] = new Record (Integer.parseInt(el[0]), el[1], Integer.parseInt(el[2]), Float.parseFloat(el[3]));
                i++;
            } // end while
            br.close();

            long tf = System.currentTimeMillis();
            System.out.println("Read " + row + " records in " + (float)(tf - ti)/1000 + " seconds.\n");
            return record;
        } // end try

        catch (Exception e) {
            System.out.println("\nError reading csv file! Probably path is wrong!");
            System.exit(0);
            return null;
        } // end catch
    } // end read

} // end class
