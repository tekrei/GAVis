package ga.fitness;

import ga.data.Chromosome;
import ga.data.DiophantineChromosome;
import ga.data.FinanceChromosome;

public class FinanceFitnessFunction implements FitnessFunction {

	

	public static int genDegerBul(FinanceChromosome fChr, int a_position) {
		try {
			return fChr.getGene(a_position);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int toplamDegerBul(FinanceChromosome a_potentialsolution) {
		int denklem1 = 0;
		int denklem2 = 0;
		int denklem3 = 0;
		int numberOfGenes = a_potentialsolution.getGeneCount();
		for (int i = 0; i < numberOfGenes; i++) {

			if (i == 1) {
				denklem1 += genDegerBul(a_potentialsolution, i) * 40;
				denklem2 += genDegerBul(a_potentialsolution, i) * 30;
				denklem3 += genDegerBul(a_potentialsolution, i) * 5;
			}
			if (i == 2) {
				denklem1 += genDegerBul(a_potentialsolution, i) * 30;
				denklem2 += genDegerBul(a_potentialsolution, i) * 30;
				denklem3 += genDegerBul(a_potentialsolution, i) * 5;
			}

			if (i == 3) {
				denklem1 += genDegerBul(a_potentialsolution, i) * 40;
				denklem2 += genDegerBul(a_potentialsolution, i) * 40;
				denklem3 += genDegerBul(a_potentialsolution, i) * 10;
			}

		}
		return ;
	}
	
	public float getFitness(FinanceChromosome a_potentialsolution) {
		int profit = 0;
		int sonuc = (genDegerBul(a_potentialsolution, 0) * 200) + (genDegerBul(a_potentialsolution, 1) * 180) + (genDegerBul(a_potentialsolution, 2) * 240);

		
		int fitness = Math.abs(sonuc - profit);

		return fitness ;
	}

	
	
}
