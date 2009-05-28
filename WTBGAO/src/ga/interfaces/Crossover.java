package ga.interfaces;

import ga.data.Chromosome;


public interface Crossover {
   public Chromosome crossover(Chromosome x, Chromosome y);
}