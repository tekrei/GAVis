package ga.data;

import java.util.Arrays;

import ga.utils.RandomNumberGenerator;

public class TSPChromosome extends Chromosome {

	public TSPChromosome(int geneCount) {
		randomize(geneCount);
	}

	public TSPChromosome() {
	}

	private void randomize(int geneCount) {
		genes = new int[geneCount];
		Arrays.fill(genes,-1);

		for (int i = 0; i < genes.length; i++) {

			int j = RandomNumberGenerator.getInstance().nextInt(geneCount);

			while (ChromosomeFactory.contains(genes, j)) {
				j = RandomNumberGenerator.getInstance().nextInt(geneCount);
			}
			genes[i] = j;

		}
	}

}
