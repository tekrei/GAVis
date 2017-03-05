package ga.data;

import ga.utility.Parameters;

public class FinanceChromosome extends Chromosome {

    FinanceChromosome(int geneCount) {
        randomize(geneCount);
    }

    private void randomize(int geneCount) {
        genes = new int[geneCount];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = Parameters.nextInt(10);
        }
    }

    // TODO how to define the problem?

    private int totalValue() {
        int denklem1 = 0;
        int denklem2 = 0;
        int denklem3 = 0;
        for (int i = 0; i < genes.length; i++) {
            if (i % 3 == 0) {
                denklem1 += genes[i] * 40;
                denklem2 += genes[i] * 40;
                denklem3 += genes[i] * 10;
            }

            if (i % 3 == 1) {
                denklem1 += genes[i] * 40;
                denklem2 += genes[i] * 30;
                denklem3 += genes[i] * 5;
            }
            if (i % 3 == 2) {
                denklem1 += genes[i] * 30;
                denklem2 += genes[i] * 30;
                denklem3 += genes[i] * 5;
            }
        }
        return denklem1 + denklem2 + denklem3;
    }

    // TODO how to maximize the result, finance problem

    public void calculateFitness() {
        int profit = totalValue();
        int sonuc = (genes[0] * 200) + (genes[1] * 180) + (genes[2] * 240);

        fitness = Math.abs(sonuc - profit);
    }
}
