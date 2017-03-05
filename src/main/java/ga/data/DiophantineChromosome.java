package ga.data;

import ga.utility.Parameters;

public class DiophantineChromosome extends Chromosome {

    DiophantineChromosome(int geneCount) {
        randomize(geneCount);
    }

    private void randomize(int geneCount) {
        genes = new int[geneCount];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Parameters.nextInt(Parameters.MAX_VALUE) + 1;
        }
    }

    public void calculateFitness() {
        //calculating ax + by + ... + nz = 1
        int sonuc = 0;
        for (int i = 0; i < genes.length; i++) {
            sonuc += getGene(i) * Parameters.VALUES[i];
        }
        fitness = Math.abs(sonuc - Parameters.VALUES[Parameters.VALUES.length - 1]);
    }
}
