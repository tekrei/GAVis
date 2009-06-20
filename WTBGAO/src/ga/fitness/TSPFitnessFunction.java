package ga.fitness;

import ga.data.Chromosome;

import java.awt.Point;
import java.util.Vector;

/**
 * Yaptigi islem sehirler arasindaki uzaklik toplamini bulmak
 * 
 * @author diyar
 * 
 */
public class TSPFitnessFunction implements FitnessFunction {
	private Vector<Point> sehirler;

	public TSPFitnessFunction(Vector<Point> _sehirler) {
		sehirler = _sehirler;
	}

	public float getFitness(Chromosome chr) {

		float fitness = 0;

		int[] genes = chr.getGenes();

		for (int i = 0; i < genes.length - 1; i++) {
			fitness += getDistance(genes[i], genes[i + 1]);
		}

		fitness += getDistance(genes[genes.length - 1], genes[0]);

		return fitness;
	}

	private float getDistance(int i, int j) {
		return (float) sehirler.get(i).distance(sehirler.get(j));
	}

}
