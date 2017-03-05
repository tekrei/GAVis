package ga.data;

public class ChromosomeFactory {

    public static final int DIOPHANTINE = 0;
    public static final int TSP = 1;
    public static final int FINANS = 2;

    private final int which;
    private final int geneCount;

    public ChromosomeFactory(int _which, int _geneCount) {
        geneCount = _geneCount;
        which = _which;
    }

    public Chromosome createChromosome() {
        switch (which) {
            case DIOPHANTINE:
                return new DiophantineChromosome(geneCount);
            case FINANS:
                return new FinanceChromosome(geneCount);
            case TSP:
            default:
                return new TSPChromosome(geneCount);
        }
    }

}
