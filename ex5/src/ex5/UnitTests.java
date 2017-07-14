package ex5;

/**
 * @author: Simone Stella (813905), Andrea Malgaroli (823429), Lorenzo Tabasso (812499)
 */

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

public class UnitTests {

    // SETTINGS ----------------------------------------------------------------
    private String csvPath = "/Users/simonestella/Desktop/ex5/italian_dist_graph.csv";
    // -------------------------------------------------------------------------

    public static void main (String[] args) {
        Result result = JUnitCore.runClasses(UnitTests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("\nResult: " + result.wasSuccessful());
    }

    @Test
    public void addUnitTest() {
        OrientedGraph g = new OrientedGraph();
        assertTrue (g.adjacencyList.isEmpty());

        g.add("Roma");
        assertTrue(g.adjacencyList.size() == 1);
        assertTrue(g.adjacencyList.containsKey("Roma"));

        g.add("Firenze");
        assertTrue(g.adjacencyList.size() == 2);
        assertTrue(g.adjacencyList.containsKey("Firenze"));

        g.add("Torino", "Milano", 100000);
        assertTrue(g.adjacencyList.size() == 4);
        assertTrue(g.adjacencyList.containsKey("Torino"));
        assertTrue(g.adjacencyList.containsKey("Milano"));
        assertTrue(g.adjacencyList.get("Torino").size() == 1 && g.EdgesNumber == 1);
        assertTrue(g.adjacencyList.get("Torino").toString().contains("Milano (100.0km)"));

        g.add("Firenze", "Genova", 200000);
        assertTrue(g.adjacencyList.size() == 5);
        assertTrue(g.adjacencyList.containsKey("Genova"));
        assertTrue(g.adjacencyList.get("Firenze").size() == 1 && g.EdgesNumber == 2);
        assertTrue(g.adjacencyList.get("Firenze").toString().contains("Genova (200.0km)"));
        System.out.println("UnitTest of 'add' completed.");
    }

    @Test
    public void weightUnitTest() {
        OrientedGraph g = new OrientedGraph();
        assertTrue (g.weight() == 0);

        g.add("Torino", "Milano", 100000);
        assertTrue (g.weight() == 100000);

        g.add("Milano", "Firenze", 250000);
        g.add("Firenze", "Genova", 200000);
        g.add("Genova", "Torino", 120000);
        assertTrue (g.weight() == (100000 + 250000 + 200000 + 120000));
        System.out.println("UnitTest of 'weight' completed.");
    }

    @Test
    public void mstUnitTest() {
        OrientedGraph g1 = new OrientedGraph();
        g1.add("Torino", "Milano", 100000);
        OrientedGraph mst1 = Mst.Kruscal(g1);
        assertTrue (g1.VerticesNumber == mst1.VerticesNumber);
        assertTrue (g1.EdgesNumber == mst1.EdgesNumber);
        assertTrue (g1.weight() == mst1.weight());

        OrientedGraph g2 = Csv.read(csvPath, ",");
        OrientedGraph mst2 = Mst.Kruscal(g2);
        assertTrue (g2.VerticesNumber == mst2.VerticesNumber && mst2.VerticesNumber == 18640);
        assertTrue (mst2.EdgesNumber == 18637);
        float mst2Weight = mst2.weight()/1000;
        assertTrue ((mst2Weight - 89939.913) < 10 || (mst2Weight - 89939.913) > -10);
        System.out.println("UnitTest of 'mst' completed.");
    }

}
