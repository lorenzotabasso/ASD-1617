package ex2;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;
import java.io.*;

public class Csv {

    /**
     * This method reads a tree, from a csv file, written in this way:
     * N:'integer node' 'character' N:'integer node, child of the first' 'character' N:'integer node, child of the first' ... \n
     * @param csvPath: the path of the csv file.
     * @param fieldsDivider: the character that divide each node.
     * @return the tree containing all the nodes read.
     */

    public static Tree<Integer> read (String csvPath, String fieldsDivider) {
        try {
            int i, elem;
            BufferedReader br = new BufferedReader(new FileReader(csvPath));
            String line = br.readLine();
            String[] fields = line.split(fieldsDivider);
            fields[0] = fields[0].substring(2, 6);
            elem = Integer.parseInt(fields[0]);
            Tree <Integer> t = new Branch<Integer> (new Leaf<Integer>(), elem, new Leaf<Integer>(), new Leaf<Integer>(), new BaseTypesComparator<Integer>());
            Tree <Integer> s;
            while (line != null) {
                fields = line.split(fieldsDivider);
                if (fields.length != 1) {
                    fields[0] = fields[0].substring(2, 6);
                    elem = Integer.parseInt(fields[0]);
                    s = t.findNode(elem);
                    fields[1] = fields[1].substring(2, 6);
                    elem = Integer.parseInt(fields[1]);
                    s.addChild(elem);
                    i = 2;
                    while (i < fields.length) {
                        s = t.findNode(elem);
                        fields[i] = fields[i].substring(2, 6);
                        elem = Integer.parseInt(fields[i]);
                        s.addSibling(elem);
                        i++;
                    }
                }
                line = br.readLine();
            }
            br.close();
            return t;
        }

        catch (Exception e) {
            throw new RuntimeException("Error reading csv file.");
        }
    }

}
