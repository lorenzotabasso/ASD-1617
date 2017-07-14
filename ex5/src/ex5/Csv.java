package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;
import java.io.*;

public class Csv {

    /**
     * This method reads a not oriented graph, from a csv file, written in this way:
     * 'vertex1' 'character' 'vertex2' 'character' 'weight of the relative edge' \n.
     * @param csvPath: the path of the csv file.
     * @param fieldsDivider: the character that divide each field.
     * @return the equivalent oriented graph containing all the vertices and edges read.
     */

    public static OrientedGraph read (String csvPath, String fieldsDivider) {
        try {
            OrientedGraph g = new OrientedGraph();
            BufferedReader br = new BufferedReader(new FileReader(csvPath));
            String line;
            String[] fields;
            while ((line = br.readLine()) != null) {
                fields = line.split(fieldsDivider);
                g.add(fields[0], fields[1], Float.parseFloat(fields[2]));
                g.add(fields[1], fields[0], Float.parseFloat(fields[2]));
            }
            br.close();
            return g;
        }

        catch (Exception e) {
            throw new RuntimeException("Error reading csv file.");
        }
    }

}
