package ex2;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSV {

    public static Tree<Integer> read (String csvfile, String fieldDividedBy) {
        try {
            String[] file = csvfile.split("/");
            System.out.println("Reading " + file[file.length-1] + " ...");
            long ti = System.currentTimeMillis();

            int i, v;
            BufferedReader br = new BufferedReader(new FileReader(csvfile));
            String line = br.readLine();
            String[] el = line.split(fieldDividedBy);
            el[0] = el[0].substring (2, 6);
            v = Integer.parseInt(el[0]);
            Tree <Integer> t = new Branch<Integer> (new Leaf(), v, new Leaf(), new Leaf());
            Tree <Integer> s;

            while (line != null) {
                el = line.split(fieldDividedBy);
                if (el.length != 1) {
                    el[0] = el[0].substring (2, 6);
                    v = Integer.parseInt(el[0]);
                    s = t.search(v);
                    el[1] = el[1].substring (2, 6);
                    v = Integer.parseInt(el[1]);
                    s.addChildL(v);
                    i = 2;
                    while (i < el.length) {
                        s = t.search(v);
                        el[i] = el[i].substring (2, 6);
                        v = Integer.parseInt(el[i]);
                        s.addBrotherR(v);
                        i++;
                    }
                }
                line = br.readLine();
            }
            br.close();

            long tf = System.currentTimeMillis();
            System.out.println("Added " + t.size() + " nodes in " + (float)(tf - ti)/1000 + " seconds.");
            return t;
        }

        catch (Exception e) {
            System.out.println("\nError reading csv file! Probably path is wrong!");
            System.exit(0);
            return null;
        }
    }

}
