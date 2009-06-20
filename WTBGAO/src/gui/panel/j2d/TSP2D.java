package gui.panel.j2d;

import ga.data.Chromosome;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Vector;

import javax.swing.JPanel;

public class TSP2D extends Java2D {
	private static final long serialVersionUID = 1L;

	private Vector<Point> sehirler;
	private Vector<Line2D.Float> yollar = new Vector<Line2D.Float>();

	public TSP2D(Vector<Point> _sehirler) {
		super("TSP Ekranı", true, // resizable
				false, // closable
				true, // maximizable
				true);// iconifiable
		this.sehirler = _sehirler;
		initialize();
	}

	private void initialize() {
		this.setSize(300, 200);
		this.add(new Canvas());
	}

	@Override
	public void update(Chromosome chr, String info) {
		// Yollari olusturalim
		yollar = new Vector<Line2D.Float>();
		int[] genes = chr.getGenes();
		for (int i = 0; i < genes.length - 1; i++) {
			yollar.add(createLine(genes[i],genes[i + 1]));
		}
		yollar.add(createLine(genes[genes.length - 1], genes[0]));
		this.updateUI();
	}

	private Line2D.Float createLine(int i, int j) {
		return new Line2D.Float(sehirler.get(i).x + 5, sehirler.get(i).y + 5,
				sehirler.get(j).x + 5, sehirler.get(j).y + 5);
	}

	class Canvas extends JPanel {
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			// Sehirler
			for (int i = 0; i < sehirler.size(); i++) {
				g2d.fill(new Ellipse2D.Float(sehirler.get(i).x,
						sehirler.get(i).y, 10f, 10f));
				g2d.drawString("C"+i,sehirler.get(i).x,sehirler.get(i).y);
			}
			// Yollar
			for (int i = 0; i < yollar.size(); i++)
				g2d.draw(yollar.get(i));
		}
	}

}
