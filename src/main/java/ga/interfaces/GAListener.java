package ga.interfaces;

import ga.data.Chromosome;

public interface GAListener {

    void iterationComplete(Chromosome best);

    void finished(Chromosome best);

    void loadPopulation(Chromosome[] population);

    void info(String info);

}