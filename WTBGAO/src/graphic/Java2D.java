package graphic;

import ga.GeneticAlgorithm;
import ga.data.Chromosome;
import ga.data.ChromosomeFactory;
import ga.data.DiophantineChromosome;
import ga.data.GAParametreler;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Java2D extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	//int x = 10;

	public void paint(Graphics g) {
		
for (int i=0;i < a;i++){
		g.drawRect(x, 10, 50, 50);
		g.drawString("aeds ", 30, 20);
		x=x+10;
}
	}
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setTitle("DrawRect");
		frame.setSize(600, 400);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = frame.getContentPane();
		contentPane.add(new Java2D());

		frame.show();
	}
}