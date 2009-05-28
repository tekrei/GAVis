package ga.fitness;

import ga.data.Chromosome;

public interface FitnessFunction {
	
	public float getFitness(Chromosome chr);

}
