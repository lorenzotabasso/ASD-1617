// package ex1;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {

    public static Record[] read (String csvfile, String fieldDividedBy) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(csvfile));
        String line;
        int row = 0;
        while ((line = br.readLine()) != null) {
            row++;
        }
        br.close();

        Record[] record = new Record[row];

        br = new BufferedReader(new FileReader(csvfile));
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] el = line.split(fieldDividedBy);
            record[i] = new Record (Integer.parseInt(el[0]), el[1], Integer.parseInt(el[2]), Float.parseFloat(el[3]));
            i++;
        }
        br.close();

        System.out.println("Read " + row + " records.\n");
        return record;
    }

}
