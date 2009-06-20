package ga.test;

import ga.GeneticAlgorithm;
import ga.data.ChromosomeFactory;
import ga.data.GAParametreler;
import ga.fitness.TSPFitnessFunction;
import ga.operators.OnePointCrossover;
import ga.operators.SwapMutation;
import ga.selection.RandomSelection;

import java.awt.Point;
import java.util.Vector;

public class TSPTest {

	public static void main(String[] args) {
		GAParametreler.init(10, 100, 0.02f, 0.7f, 4, new ChromosomeFactory(
				ChromosomeFactory.TSP));
		new GeneticAlgorithm(GAParametreler.getInstance(),
				new OnePointCrossover(), new SwapMutation(),
				new RandomSelection(), new TSPFitnessFunction(new Vector<Point>())).calculate(0);
	}
}
