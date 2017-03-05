package ga.test;

import ga.GeneticAlgorithm;
import ga.data.ChromosomeFactory;
import ga.utility.Parameters;
import org.junit.Test;

import java.awt.*;
import java.util.Vector;

/**
 * Tests for GA execution
 * <p>
 * Created by T. E. Kalayci on 04/03/17.
 */
public class GATest {

    @Test
    public void testDiophantine() {
        int[] coefficient = new int[6];
        for (int i = 0; i < 5; i++) {
            coefficient[i] = Parameters.nextInt(Parameters.MAX_VALUE);
        }
        coefficient[5] = Parameters.nextInt(500);
        Parameters.VALUES = coefficient;
        runGA(ChromosomeFactory.DIOPHANTINE, 5);
    }

    @Test
    public void testTSP() {
        Vector<Point> sehirler = new Vector<>();
        for (int i = 0; i < 100; i++) {
            sehirler.add(new Point(Parameters
                    .nextInt(300), Parameters
                    .nextInt(200)));
        }
        Parameters.CITIES = sehirler;
        runGA(ChromosomeFactory.TSP, sehirler.size());
    }

    @Test
    public void testFinans() {
        runGA(ChromosomeFactory.FINANS, 4);
    }

    private void runGA(int problemType, int geneCount) {
        Parameters.chromosomeFactory = new ChromosomeFactory(problemType, geneCount);
        new GeneticAlgorithm().startGA(0);
    }
}
