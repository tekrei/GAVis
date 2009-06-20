package gui.panel.j2d;

import ga.data.Chromosome;

import java.awt.BorderLayout;

import javax.swing.JLabel;

public class Finance2D extends Java2D {
	private static final long serialVersionUID = 1L;

	private JLabel lblInfo;

	public Finance2D() {
		super("Finance2D Ekranı",
		          true, //resizable
		          false, //closable
		          true, //maximizable
		          true);//iconifiable
		initialize();
	}

	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new BorderLayout());
		lblInfo = new JLabel();
		this.add(lblInfo, BorderLayout.CENTER);
	}

	@Override
	public void update(Chromosome chr, String info) {
		// TODO Finans gorsellestirme

	}

}
