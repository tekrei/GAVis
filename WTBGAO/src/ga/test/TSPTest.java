package ga.test;

import ga.GeneticAlgorithm;
import ga.data.ChromosomeFactory;
import ga.data.GAParametreler;
import ga.fitness.TSPFitnessFunction;
import ga.operators.OnePointCrossover;
import ga.operators.RandomSelection;
import ga.operators.SwapMutation;

public class TSPTest {

	public static void main(String[] args) {
		GAParametreler.init(10, 100, 0.02f, 0.7f, 4, new ChromosomeFactory(
				ChromosomeFactory.DIOPHANTINE));
		new GeneticAlgorithm(GAParametreler.getInstance(),
				new OnePointCrossover(), new SwapMutation(),
				new RandomSelection(), new TSPFitnessFunction())
				.calculate();
	}
}
