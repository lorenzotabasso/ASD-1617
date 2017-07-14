package ex1;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;
import java.io.*;

public class Csv {

    /**
     * This method reads records, from a csv file, with this structure:
     * 'integer field' 'character' 'string field' 'character' 'integer field' 'character' 'floating point field' \n.
     * @param csvPath: the path of the csv file.
     * @param fieldsDivider: the character that divide each field of a record.
     * @param recordsToRead: the number of record of the csv file to be read.
     * @return the 'Record' array containing all the records read.
     */

    public static Record[] read (String csvPath, char fieldsDivider, int recordsToRead) {
        try {
            System.out.println("Reading csv file ...");
            long start = System.currentTimeMillis();

            int i = 0;
            int p, q;
            Record[] records = new Record[recordsToRead];
            String line;
            String[] fields = new String[3];

            BufferedReader br = new BufferedReader(new FileReader(csvPath));
            while ((line = br.readLine()) != null && i < recordsToRead) {
                p = line.indexOf(fieldsDivider);
                q = line.indexOf(fieldsDivider, p + 1);
                fields[0] = line.substring(p + 1, q);
                p = line.indexOf (fieldsDivider, q + 1);
                fields[1] = line.substring(q + 1, p);
                fields[2] = line.substring(p + 1, line.length()); // We used 'indexOf' and 'substring' instead of 'split' because they are less heavy instructions.
                records[i] = new Record (fields[0], Integer.parseInt(fields[1]), Float.parseFloat(fields[2]));
                i++;
            }
            br.close();

            long end = System.currentTimeMillis();
            System.out.println("Read " + records.length + " records in " + (float)(end - start)/1000 + " seconds.");

            return records;
        }

        catch (Exception e) {
            throw new RuntimeException("Error reading csv file.");
        }
    }

}
