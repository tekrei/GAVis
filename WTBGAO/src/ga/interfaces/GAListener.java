package ga.interfaces;

import ga.data.Chromosome;

public interface GAListener {
	
	public void generation(int generation, Chromosome chr);

	public void finished(Chromosome elite);
	
	public void loadPopulation(Chromosome[] population);

}