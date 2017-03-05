package ga.utility;

import ga.data.Chromosome;
import ga.data.ChromosomeFactory;

import java.awt.*;
import java.util.Vector;

public class Parameters {

    private final static MersenneTwisterFast generator = new MersenneTwisterFast();
    public static int populationSize = 100;
    public static int generationCount = 100;
    public static float mutationProbability = 0.1f;
    public static float crossoverProbability = 0.8f;
    public static boolean elitism = true;
    //TSP
    public static Vector<Point> CITIES;
    //diophantine
    //last element is the expected result
    public static int MAX_VALUE = 5;
    public static int MAX_VALUE_2 = 25;
    public static int[] VALUES;
    //GA
    public static ChromosomeFactory chromosomeFactory;

    private Parameters(int populationSize, int generationCount,
                       float mutationProbability, float crossoverProbability, ChromosomeFactory _cf) {
        super();

    }

    public static int nextInt(int upperLimit) {
        return generator.nextInt(upperLimit);
    }

    public static float nextFloat() {
        return generator.nextFloat();
    }

    public static boolean contains(int[] a, int b) {
        for (int anA : a) {
            if (b == anA) {
                return true;
            }
        }
        return false;
    }

    public static float calculateDistance(int i, int j) {
        return (float) CITIES.get(i).distance(CITIES.get(j));
    }

    public static Chromosome createChromosome() {
        return chromosomeFactory.createChromosome();
    }

    public static void setParams(int ps, int gs, float cp, float mp) {
        populationSize = ps;
        generationCount = gs;
        crossoverProbability = cp;
        mutationProbability = mp;
    }

    public static String parameters() {
        return String.format("Population size:%d Generation count:%d Crossover probability:%s Mutation probability:%s Elitism:%s", populationSize, generationCount, crossoverProbability, mutationProbability, elitism);
    }
}
