package ga.test;

import ga.GeneticAlgorithm;
import ga.data.ChromosomeFactory;
import ga.data.GAParametreler;
import ga.fitness.FinanceFitnessFunction;
import ga.operators.OnePointCrossover;
import ga.operators.SwapMutation;
import ga.selection.RandomSelection;

public class FinansTest {

	public static void main(String[] args) {
		GAParametreler.init(10, 100, 0.02f, 0.7f, 4, new ChromosomeFactory(
				ChromosomeFactory.DIOPHANTINE));
		new GeneticAlgorithm(GAParametreler.getInstance(),
				new OnePointCrossover(), new SwapMutation(),
				new RandomSelection(), new FinanceFitnessFunction())
				.calculate(0);
	}
}
