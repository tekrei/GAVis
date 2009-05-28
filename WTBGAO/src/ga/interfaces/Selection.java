package ga.interfaces;

import ga.data.Chromosome;

public interface Selection {
	public Chromosome[] select(Chromosome[] population, int selectionSize);
}