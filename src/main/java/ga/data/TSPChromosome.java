package ga.data;

import ga.utility.Parameters;

import java.util.Arrays;

class TSPChromosome extends Chromosome {

    TSPChromosome(int geneCount) {
        randomGenes(geneCount);
    }

    private void randomGenes(int geneCount) {
        genes = new int[geneCount];
        Arrays.fill(genes, -1);
        for (int i = 0; i < genes.length; i++) {
            int j = Parameters.nextInt(geneCount);
            while (Parameters.contains(genes, j)) {
                j = Parameters.nextInt(geneCount);
            }
            genes[i] = j;
        }
    }

    public void calculateFitness() {
        if (Parameters.CITIES == null || Parameters.CITIES.size() < 1) {
            System.out.println("Please set CITIES first!");
            return;
        }
        fitness = 0;
        for (int i = 0; i < genes.length - 1; i++) {
            fitness += Parameters.calculateDistance(genes[i], genes[i + 1]);
        }
        fitness += Parameters.calculateDistance(genes[genes.length - 1], genes[0]);
    }

    @Override
    public void setGenes(int[] _genes) {
        int[] newGenes = new int[_genes.length];
        Arrays.fill(newGenes, -1);
        for (int i = 0; i < genes.length; i++) {
            if (!Parameters.contains(newGenes, _genes[i])) {
                newGenes[i] = _genes[i];
            }
        }
        for (int i = 0; i < genes.length; i++) {
            if (newGenes[i] == -1) {
                int j = Parameters.nextInt(getGeneCount());
                while (Parameters.contains(newGenes, j)) {
                    j = Parameters.nextInt(getGeneCount());
                }
                newGenes[i] = j;
            }
        }
        super.setGenes(newGenes);
    }


}
