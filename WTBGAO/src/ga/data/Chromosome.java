package ga.data;

public abstract class Chromosome {

	protected int[] genes;
	float fitness;

	public Chromosome() {
		super();
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	public float getFitness() {
		return fitness;
	}

	public void setFitness(float fitness) {
		this.fitness = fitness;
	}

	public int getGene(int i) {
	
		return genes[i];
	}

	public void setGene(int i, int newValue) {
		genes[i] = newValue;
	
	}

	public int getGeneCount() {
		
		return genes.length;
	}

	public abstract String toString();
}