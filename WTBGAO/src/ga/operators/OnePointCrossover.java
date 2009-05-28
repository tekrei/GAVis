package ga.operators;

import ga.data.Chromosome;
import ga.data.GAParametreler;
import ga.interfaces.Crossover;
import ga.utils.RandomNumberGenerator;

public class OnePointCrossover implements Crossover {

	public Chromosome crossover(Chromosome one, Chromosome two) {

		// Caprazlama kesim noktasi rastgele belirleniyor
		int cutPoint = RandomNumberGenerator.getInstance().nextInt(
				one.getGeneCount());

		return crossover(one.getGenes(), two.getGenes(), cutPoint);
	}

	private Chromosome crossover(int[] genes, int[] genes2, int cutPoint) {
		Chromosome chr = GAParametreler.getInstance().createChromosome(genes.length);
		int[] newGenes = new int[genes.length];

		for (int i = 0; i < newGenes.length; i++) {
			if (i < cutPoint)
				newGenes[i] = genes[i];
			else
				newGenes[i] = genes2[i];
		}
		chr.setGenes(newGenes);
		return chr;
	}
}