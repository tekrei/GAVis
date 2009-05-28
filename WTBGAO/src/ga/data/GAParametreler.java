package ga.data;

public class GAParametreler {

	private static GAParametreler instance = null;

	private int populationSize;
	private int generationCount;
	private float mutationProbability;
	private float crossoverProbability;
	private int geneCount;
	private ChromosomeFactory chromosomeFactory;

	private GAParametreler(int populationSize, int generationCount,
			float mutationProbability, float crossoverProbability,
			int geneCount, ChromosomeFactory _cf) {
		super();
		this.populationSize = populationSize;
		this.generationCount = generationCount;
		this.mutationProbability = mutationProbability;
		this.crossoverProbability = crossoverProbability;
		this.geneCount = geneCount;
		this.chromosomeFactory = _cf;
	}

	public static void init(int populationSize, int generationCount,
			float mutationProbability, float crossoverProbability,
			int geneCount, ChromosomeFactory _cf) {
		instance = new GAParametreler(populationSize, generationCount,
				mutationProbability, crossoverProbability, geneCount, _cf);
	}

	public static GAParametreler getInstance() {
		return instance;
	}

	public int getGeneCount() {
		return geneCount;
	}

	public void setGeneCount(int geneCount) {
		this.geneCount = geneCount;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public int getGenerationCount() {
		return generationCount;
	}

	public void setGenerationCount(int generationCount) {
		this.generationCount = generationCount;
	}

	public float getMutationProbability() {
		return mutationProbability;
	}

	public void setMutationProbability(float mutationProbability) {
		this.mutationProbability = mutationProbability;
	}

	public float getCrossoverProbability() {
		return crossoverProbability;
	}

	public void setCrossoverProbability(float crossoverProbability) {
		this.crossoverProbability = crossoverProbability;
	}

	public Chromosome createChromosome(int geneCount) {
		return this.chromosomeFactory.createChromosome(geneCount);
	}

}
