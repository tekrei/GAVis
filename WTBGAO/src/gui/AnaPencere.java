package gui;

import ga.GeneticAlgorithm;
import ga.data.Chromosome;
import ga.data.ChromosomeFactory;
import ga.data.GAParametreler;
import ga.fitness.DiophantineFitnessFunction;
import ga.fitness.FinanceFitnessFunction;
import ga.fitness.FitnessFunction;
import ga.fitness.TSPFitnessFunction;
import ga.interfaces.GAListener;
import ga.operators.OnePointCrossover;
import ga.operators.SwapMutation;
import ga.selection.RandomSelection;
import ga.utils.RandomNumberGenerator;
import gui.panel.DugmelerPanel;
import gui.panel.GAParametreleriPanel;
import gui.panel.IslemlerListesiPanel;
import gui.panel.KromozomPanel;
import gui.panel.j2d.Diophantine2D;
import gui.panel.j2d.Finance2D;
import gui.panel.j2d.Java2D;
import gui.panel.j2d.TSP2D;
import gui.utils.MenuUtils;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AnaPencere extends JFrame implements ActionListener, GAListener {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktop = null;

	// DEGERLER
	public final static String DIOPHANTINE = "Diophantine";
	public final static String TSP = "TSP";
	public final static String FINANS = "Finans";

	// ISLEMLER
	public final static String BASLAT = "Başlat";
	public final static String DURAKLAT = "Duraklat";
	public final static String DURDUR = "Durdur";
	public final static String ADIM = "Adım";

	Java2D cp;
	GeneticAlgorithm ga;
	GAParametreleriPanel gap;
	KromozomPanel kt;

	public AnaPencere() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(800, 600);
		this.setJMenuBar(new MenuUtils(this).getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Genetik Algoritma Öğreticisi");
	}

	private JDesktopPane getJContentPane() {
		if (desktop == null) {
			desktop = new JDesktopPane();
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

			desktop.setLayout(null);

			gap = new GAParametreleriPanel();
			gap.setVisible(true);
			gap.setBounds(new Rectangle(0, 410, 226, 136));
			desktop.add(gap);

			problemYukle(DIOPHANTINE);

			DugmelerPanel dp = new DugmelerPanel(this);
			dp.setBounds(new Rectangle(470, 510, 311, 16));
			desktop.add(dp);

			IslemlerListesiPanel il = new IslemlerListesiPanel();
			il.setBounds(new Rectangle(470, 285, 310, 226));
			il.setToolTipText("İşlemler Listesi");
			desktop.add(il);

			kt = new KromozomPanel(null);
			kt.setVisible(true);
			kt.setBounds(new Rectangle(470, 0, 311, 286));
			desktop.add(kt);
		}
		return desktop;
	}

	public void actionPerformed(ActionEvent event) {
		problemYukle(event.getActionCommand());
	}

	public void loadPanel() {
		cp.setVisible(true);
		cp.setBounds(new Rectangle(0, 0, 466, 411));
		desktop.add(cp);
	}

	private void problemYukle(String actionCommand) {
		if (cp != null)
			cp.dispose();
		if (actionCommand.equals(DIOPHANTINE)) {
			ga = initGA(ChromosomeFactory.DIOPHANTINE,
					new DiophantineFitnessFunction(), 4);
			cp = new Diophantine2D();
			loadPanel();
		} else if (actionCommand.equals(TSP)) {
			// Once rastgele sehir olusturalim
			Vector<Point> sehirler = new Vector<Point>();
			int adet = Integer.parseInt((String) JOptionPane.showInputDialog(
					this, "Kaç adet şehir?\n", "Şehir sayısı",
					JOptionPane.PLAIN_MESSAGE, null, null, "10"));

			for (int i = 0; i < adet; i++) {
				sehirler.add(new Point(RandomNumberGenerator.getInstance()
						.nextInt(300), RandomNumberGenerator.getInstance()
						.nextInt(200)));
			}

			ga = initGA(ChromosomeFactory.TSP,
					new TSPFitnessFunction(sehirler), sehirler.size());
			cp = new TSP2D(sehirler);
			loadPanel();
		} else if (actionCommand.equals(FINANS)) {
			// TODO finans gen sayisi degistirilecek
			ga = initGA(ChromosomeFactory.FINANS, new FinanceFitnessFunction(),
					5);
			cp = new Finance2D();
			loadPanel();
		}
		ga.setGAListener(this);
	}

	private GeneticAlgorithm initGA(int type, FitnessFunction ff, int geneCount) {
		GAParametreler.init(100, 100, 0.02f, 0.7f, geneCount,
				new ChromosomeFactory(type));
		gap.updateParameters();

		return new GeneticAlgorithm(GAParametreler.getInstance(),
				new OnePointCrossover(), new SwapMutation(),
				new RandomSelection(), ff);
	}

	public void gaIslem(String islem) {
		if (islem.equals(BASLAT)) {
			gap.updateParameters();
			ga.baslat(1000);
		} else if (islem.equals(DURAKLAT)) {
			// TODO parametre degistirip devam ettirebilecek mi?
			ga.duraklat();
		} else if (islem.equals(DURDUR)) {
			ga.durdur();
		} else if (islem.equals(ADIM)) {
			// TODO adim adim nasil yapilacak?
			System.out.println("adim adim");
		}
	}

	public void finished(Chromosome elite) {
		cp.update(elite, "SONUÇ");
	}

	public void generation(int generation, Chromosome chr) {
		cp.update(chr, "");
	}

	public void loadPopulation(Chromosome[] population) {
		kt.refreshData(Arrays.asList(population));
	}

	public static void main(String[] args) {
		(new AnaPencere()).setVisible(true);
	}
} // @jve:decl-index=0:visual-constraint="10,10"
