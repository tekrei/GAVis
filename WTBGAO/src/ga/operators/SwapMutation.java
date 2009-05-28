package ga.operators;

import ga.data.Chromosome;
import ga.interfaces.Mutation;
import ga.utils.RandomNumberGenerator;

public class SwapMutation implements Mutation {

	public Chromosome mutate(Chromosome chr) {
		chr.setGenes(swap(chr.getGenes()));
		return chr;
	}

	private int[] swap(int[] genes) {
		int i = RandomNumberGenerator.getInstance().nextInt(genes.length);
		int j = RandomNumberGenerator.getInstance().nextInt(genes.length);
		int temp = genes[i];
		genes[i] = genes[j];
		genes[i] = temp;
		return genes;
	}
}
