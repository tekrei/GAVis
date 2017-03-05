package ui.panel.j2d;

import ga.data.Chromosome;
import ga.utility.Parameters;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TSP2D extends Java2D {
    private final Canvas canvas = new Canvas();
    private Chromosome chr;

    public TSP2D() {
        super("TSP Problem", true, false, true, true);
        this.setSize(300, 200);
        this.add(canvas);
    }

    @Override
    public void update(Chromosome _chr) {
        chr = _chr;
        canvas.updateUI();
    }

    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < Parameters.CITIES.size(); i++) {
                g2d.fill(new Ellipse2D.Float(Parameters.CITIES.get(i).x, Parameters.CITIES.get(i).y, 10f, 10f));
                g2d.drawString("C" + i, Parameters.CITIES.get(i).x, Parameters.CITIES.get(i).y);
            }
            if (chr != null) {
                for (int i = 0; i < chr.getGeneCount() - 1; i++) {
                    Point c1 = Parameters.CITIES.get(chr.getGene(i));
                    Point c2 = Parameters.CITIES.get(chr.getGene(i + 1));
                    g2d.drawLine(c1.x + 5, c1.y + 5, c2.x + 5, c2.y + 5);
                }
                //line between last and first element
                Point c1 = Parameters.CITIES.get(chr.getGene(0));
                Point c2 = Parameters.CITIES.get(chr.getGene(chr.getGeneCount() - 1));
                g2d.drawLine(c1.x + 5, c1.y + 5, c2.x + 5, c2.y + 5);
            }
        }
    }

}
