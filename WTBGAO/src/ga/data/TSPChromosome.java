package ga.data;

import ga.utils.RandomNumberGenerator;

public class TSPChromosome extends Chromosome{

	public TSPChromosome(int geneCount){
		randomize(geneCount);
	}

	public TSPChromosome() {
	}

	private void randomize(int geneCount) {
		genes = new int[geneCount];
		
		for (int i = 0; i < genes.length; i++) {
			genes[i] = RandomNumberGenerator.getInstance().nextInt(geneCount);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
