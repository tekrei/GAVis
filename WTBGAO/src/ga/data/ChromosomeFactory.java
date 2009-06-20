package ga.data;

public class ChromosomeFactory {

	public static int DIOPHANTINE = 0;
	public static int TSP = 1;
	public static int FINANS = 2;

	private int which;

	public ChromosomeFactory(int _which) {
		which = _which;
	}

	public Chromosome createChromosome(int geneCount) {
		if (which == DIOPHANTINE)
			return new DiophantineChromosome(geneCount);
		else if (which == TSP)
			return new TSPChromosome(geneCount);
		// TODO Finans Kromozomu
		return null;
	}

	
	public static boolean contains(int[] a, int b) {
		for (int i = 0; i < a.length; i++) {
			if (b == a[i]) {
				return true;
			}

		}
		return false;
	}
	
}
