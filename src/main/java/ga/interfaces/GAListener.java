package ga.interfaces;

import ga.data.Chromosome;

public interface GAListener {

    void generation(int generation, Chromosome chr);

    void finished(Chromosome elite);

    void loadPopulation(Chromosome[] population);

    void info(String info);

}