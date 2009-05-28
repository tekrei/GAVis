package ga.operators;

import ga.data.Chromosome;
import ga.interfaces.Selection;
import ga.utils.RandomNumberGenerator;

public class RandomSelection implements Selection {

	public Chromosome[] select(Chromosome[] population, int selectionSize) {
		Chromosome[] selections = new Chromosome[selectionSize];
		
		for (int i = 0; i < selections.length; i++) {
			selections[i] = population[RandomNumberGenerator.getInstance().nextInt(population.length)];
		}
		
		return selections;
	}

	

}
