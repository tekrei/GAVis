package ga.interfaces;

import ga.data.Chromosome;

public interface Mutation {
	public Chromosome mutate(Chromosome chr);
}
