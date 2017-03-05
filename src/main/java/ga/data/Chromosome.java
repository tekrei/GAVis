package ga.data;

public abstract class Chromosome {
    int[] genes;
    float fitness;

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public String getGenesAsString() {
        StringBuilder builder = new StringBuilder();
        for (int gene : genes) {
            builder.append(gene).append(" ");
        }
        return builder.toString();
    }

    public abstract void calculateFitness();

    public float getFitness() {
        return fitness;
    }

    public int getGene(int i) {
        return genes[i];
    }

    public int getGeneCount() {
        return genes.length;
    }

    public String toString() {
        return getGenesAsString() + " Fitness:" + getFitness();
    }

    public void setGene(int i, int gene) {
        genes[i] = gene;
    }
}