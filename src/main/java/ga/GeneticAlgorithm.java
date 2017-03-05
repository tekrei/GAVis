package ga;

import ga.data.Chromosome;
import ga.interfaces.GAListener;
import ga.utility.Parameters;
import ga.utility.QubbleSortAlgorithm;

public class GeneticAlgorithm {
    private boolean stopped = false;
    private boolean paused = false;
    private Chromosome elite;
    private Chromosome[] population;
    private GAListener gaListener = null;

    public GeneticAlgorithm() {
    }

    public void setGAListener(GAListener gal) {
        this.gaListener = gal;
    }

    public Chromosome startGA(int waitingTime) {
        final long baslangic = System.currentTimeMillis();
        generateRandomPopulation(Parameters.populationSize);
        int generation = 0;
        calculateAndSort();
        while (generation < Parameters.generationCount) {
            if (stopped)
                break;
            while (paused) {
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            generation++;
            final long bas = System.currentTimeMillis();
            crossover();
            calculateAndSort();
            mutate();
            calculateAndSort();
            if (Parameters.elitism) {
                elitism();
            }
            if (gaListener != null) {
                gaListener.generation(generation, population[0]);
                gaListener.loadPopulation(population);
            }
            info("GENERATION " + generation + "(" + (System.currentTimeMillis() - bas) + "ms) BEST:" + population[0].toString());
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        info("TOTAL TIME: " + (System.currentTimeMillis() - baslangic) + "ms");
        if (gaListener != null)
            gaListener.finished(population[0]);
        return population[0];
    }

    public void stop() {
        stopped = true;
    }

    public void pause() {
        paused = !paused;
    }

    private void calculateAndSort() {
        // Calculate cost for every individual of population
        for (final Chromosome chr : population) {
            chr.calculateFitness();
        }
        // Sort population
        QubbleSortAlgorithm.getInstance().sort(population);
    }

    private void crossover() {
        for (int i = 0; i < population.length; i++) {
            if (Parameters.nextFloat() < Parameters.crossoverProbability) {
                int j = Parameters.nextInt(population.length);
                while (i == j) {
                    j = Parameters.nextInt(population.length);
                }
                Chromosome chr = crossover(population[i], population[j]);
                if (chr.getFitness() < population[i].getFitness()) {
                    population[i] = chr;
                    info("SUCCESSFUL CROSSOVER BETWEEN " + population[i] + " AND " + population[j]);
                }
            }
        }
    }

    //one point crossover
    private Chromosome crossover(Chromosome one, Chromosome two) {
        int cutPoint = Parameters.nextInt(one.getGeneCount());
        int[] genes = one.getGenes();
        Chromosome chr = Parameters.createChromosome();
        int[] newGenes = new int[genes.length];
        for (int i = 0; i < newGenes.length; i++) {
            if (i < cutPoint) {
                newGenes[i] = genes[i];
            } else {
                newGenes[i] = two.getGenes()[i];
            }
        }
        chr.setGenes(newGenes);
        chr.calculateFitness();
        return chr;
    }

    private void elitism() {
        if (elite == null) {
            elite = Parameters.createChromosome();
            elite.calculateFitness();
        }
        if (elite.getFitness() > population[0].getFitness()) {
            elite.setGenes(population[0].getGenes().clone());
            elite.calculateFitness();
        }
        //push elite to the population
        population[population.length - 1].setGenes(elite.getGenes().clone());
    }

    private void generateRandomPopulation(final int populationSize) {
        population = new Chromosome[populationSize];
        final long bas = System.currentTimeMillis();

        // Generate random population
        for (int i = 0; i < populationSize; i++) {
            population[i] = Parameters.createChromosome();
        }
        info("INIT POPULATION:" + (System.currentTimeMillis() - bas) + "ms");
    }

    //swap mutation
    private void mutate() {
        for (Chromosome aPopulation : population) {
            if (Parameters.nextFloat() < Parameters.mutationProbability) {
                int i = Parameters.nextInt(aPopulation.getGeneCount());
                int j = Parameters.nextInt(aPopulation.getGeneCount());
                int temp = aPopulation.getGene(i);
                aPopulation.setGene(i, aPopulation.getGene(j));
                aPopulation.setGene(j, temp);
                info("MUTATED " + aPopulation);
            }
        }
    }

    private void info(String info) {
        if (gaListener != null)
            gaListener.info(info + "\n");
        else {
            System.out.println(info + "\n");
        }
    }

    public void start() {
        stopped = false;
        paused = false;
        Thread th = new Thread(() -> startGA(250));
        th.start();
    }
}