package ga.data;

import ga.utils.RandomNumberGenerator;

public class DiophantineChromosome extends Chromosome {

	public DiophantineChromosome(int geneCount){
		randomize(geneCount);
	}

	public DiophantineChromosome() {
	}

	private void randomize(int geneCount) {
		genes = new int[geneCount];
		
		for (int i = 0; i < genes.length; i++) {
			genes[i] = RandomNumberGenerator.getInstance().nextInt(10);
		}
	}
}
