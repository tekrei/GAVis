package gui.panel.j2d;

import javax.swing.JInternalFrame;

import ga.data.Chromosome;

public abstract class Java2D extends JInternalFrame{
	private static final long serialVersionUID = 1L;

	public Java2D(String s, boolean b, boolean c, boolean d, boolean e) {
		super(s,b,c,d,e);
	}

	public abstract void update(Chromosome chr, String info);
}