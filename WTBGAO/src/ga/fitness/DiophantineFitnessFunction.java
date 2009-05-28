package ga.fitness;

import ga.data.Chromosome;
import ga.data.DiophantineChromosome;

public class DiophantineFitnessFunction implements FitnessFunction {
	private static final long serialVersionUID = 1L;

	public float getFitness(Chromosome chr) {
		int beklenenDeger = 70;

		int toplam = toplamDegerBul((DiophantineChromosome)chr);
		int fitness = Math.abs(toplam - beklenenDeger);

		return fitness;
	}

	public static int genDegerBul(DiophantineChromosome dChr, int a_position) {
		try {
			return dChr.getGene(a_position);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int toplamDegerBul(DiophantineChromosome a_potentialsolution) {
		int sonuc = 0;
		int numberOfGenes = a_potentialsolution.getGeneCount();
		for (int i = 0; i < numberOfGenes; i++) {
			sonuc += genDegerBul(a_potentialsolution, i) * (i + 1);
		}
		return sonuc;
	}

}