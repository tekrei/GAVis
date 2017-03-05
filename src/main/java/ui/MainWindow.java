package ui;

import ga.GeneticAlgorithm;
import ga.data.Chromosome;
import ga.data.ChromosomeFactory;
import ga.interfaces.GAListener;
import ga.utility.Parameters;
import ui.component.MenuUtils;
import ui.panel.Buttons;
import ui.panel.Chromosomes;
import ui.panel.Operations;
import ui.panel.Settings;
import ui.panel.j2d.Diophantine2D;
import ui.panel.j2d.Finance2D;
import ui.panel.j2d.Java2D;
import ui.panel.j2d.TSP2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class MainWindow extends JFrame implements ActionListener, GAListener {

    // PROBLEMS
    public final static String DIOPHANTINE = "Diophantine";
    public final static String TSP = "TSP";
    public final static String FINANS = "Finance";
    // OPERATIONS
    public final static String BASLAT = "Start";
    public final static String DURAKLAT = "Pause";
    public final static String DURDUR = "Stop";
    public final static String ADIM = "Step";
    //PANELS
    private Java2D cp;
    private GeneticAlgorithm ga;
    private Chromosomes chromosomes;
    private JDesktopPane desktop = null;

    private Operations operations;

    private MainWindow() {
        super();
        initialize();
    }

    public static void main(String[] args) {
        (new MainWindow()).setVisible(true);
    }

    private void initialize() {
        this.setSize(1000, 700);
        this.setJMenuBar(new MenuUtils(this).getJJMenuBar());
        desktop = new JDesktopPane();
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktop.setLayout(null);

        Buttons dp = new Buttons(this);
        dp.setBounds(new Rectangle(500, 75, 200, 75));
        desktop.add(dp);
        loadProblem(DIOPHANTINE);

        Settings gap = new Settings();
        gap.setBounds(new Rectangle(700, 475, 300, 175));
        desktop.add(gap);

        operations = new Operations();
        operations.setBounds(new Rectangle(0, 475, 700, 175));
        desktop.add(operations);

        chromosomes = new Chromosomes();
        chromosomes.setBounds(new Rectangle(700, 0, 300, 475));
        desktop.add(chromosomes);

        this.setLayout(new BorderLayout());
        this.add(desktop, BorderLayout.CENTER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Genetic Algorithm Visualizer");
    }

    public void actionPerformed(ActionEvent event) {
        loadProblem(event.getActionCommand());
    }

    private void loadPanel() {
        cp.setVisible(true);
        cp.setBounds(new Rectangle(0, 0, 700, 475));
        desktop.add(cp);
    }

    private void loadProblem(String actionCommand) {
        if (cp != null)
            cp.dispose();
        switch (actionCommand) {
            case DIOPHANTINE:
                diophantine();
                break;
            case TSP:
                tsp();
                break;
            case FINANS:
                finance();
                break;
        }
        ga.setGAListener(this);
    }

    private void finance() {
        //init GA parameters
        Parameters.chromosomeFactory = new ChromosomeFactory(ChromosomeFactory.FINANS, 5);
        //create GA
        ga = new GeneticAlgorithm();
        cp = new Finance2D();
        loadPanel();
    }

    private void tsp() {
        Vector<Point> sehirler = new Vector<>();
        int adet = Integer.parseInt((String) JOptionPane.showInputDialog(
                this, "How many cities you want?\n", "City Count",
                JOptionPane.PLAIN_MESSAGE, null, null, "25"));
        for (int i = 0; i < adet; i++) {
            sehirler.add(new Point(Parameters.nextInt(625), Parameters.nextInt(425)));
        }
        Parameters.CITIES = sehirler;
        Parameters.chromosomeFactory = new ChromosomeFactory(ChromosomeFactory.TSP, sehirler.size());
        //create GA
        ga = new GeneticAlgorithm();
        cp = new TSP2D();
        loadPanel();
    }

    private void diophantine() {
        //generate equation
        int count = Integer.parseInt((String) JOptionPane.showInputDialog(
                this, "How many coefficients?\n", "Coefficient Count",
                JOptionPane.PLAIN_MESSAGE, null, null, "5"));
        int[] coefficient = new int[count + 1];
        for (int i = 0; i < count; i++) {
            coefficient[i] = Parameters.nextInt(Parameters.MAX_VALUE) + 1;
        }
        coefficient[count] = Parameters.nextInt(count * Parameters.MAX_VALUE_2);
        Parameters.VALUES = coefficient;

        //init GA parameters
        Parameters.chromosomeFactory = new ChromosomeFactory(ChromosomeFactory.DIOPHANTINE, coefficient.length - 1);
        //create GA
        ga = new GeneticAlgorithm();
        cp = new Diophantine2D();
        loadPanel();
    }

    public void gaIslem(String islem) {
        switch (islem) {
            case BASLAT:
                //TODO clear things
                info("STARTED GA USING " + Parameters.parameters());
                ga.start();
                break;
            case DURAKLAT:
                ga.pause();
                operations.addInfo("PAUSED GA");
                break;
            case DURDUR:
                operations.addInfo("STOPPED GA");
                ga.stop();
                break;
            case ADIM:
                // TODO step by step visualisation
                break;
        }
    }

    public void finished(Chromosome best) {
        cp.update(best);
    }

    public void iterationComplete(Chromosome best) {
        cp.update(best);
    }

    public void loadPopulation(Chromosome[] population) {
        chromosomes.refreshData(Arrays.asList(population));
    }

    public void info(String info) {
        operations.addInfo(info);
    }
} // @jve:decl-index=0:visual-constraint="10,10"
