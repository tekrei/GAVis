package ga.data;

import ga.utils.RandomNumberGenerator;

public class FinanceChromosome extends Chromosome {

	public FinanceChromosome(int geneCount){
		randomize(geneCount);
	}

	public FinanceChromosome() {
	}

	private void randomize(int geneCount) {
		genes = new int[geneCount];
		
		for (int i = 0; i < genes.length; i++) {
			genes[i] = RandomNumberGenerator.getInstance().nextInt(10);
		}
	}
	
	// TODO kromozomların gen değerlerinin alabileceği aralık düzenlenmeli a,b,c ye göre ayrı nasıl yapılır ki?
}
