package gui.utils;

import gui.AnaPencere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuUtils {
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem miDiophantine = null;
	private JMenuItem miTSP = null;
	private JMenuItem miFinans = null;
	private JMenuItem miCikis = null;
	private AnaPencere anaPencere;
	
	public MenuUtils(AnaPencere _anaPencere){
		this.anaPencere = _anaPencere;
	}

	public JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu("Problem");
			ButtonGroup bg = new ButtonGroup();
			JMenuItem jmi = getMIDiophantine();
			bg.add(jmi);
			jMenu.add(jmi);
			jmi = getMITSP();
			bg.add(jmi);
			jMenu.add(jmi);
			jmi = getMIFinans();
			bg.add(jmi);
			jMenu.add(jmi);
			jmi = getMICikis();
			bg.add(jmi);
			jMenu.add(jmi);
		}
		return jMenu;
	}

	private JMenuItem getMIDiophantine() {
		if (miDiophantine == null) {
			miDiophantine = new JRadioButtonMenuItem(AnaPencere.DIOPHANTINE);
			miDiophantine.setActionCommand(AnaPencere.DIOPHANTINE);
			miDiophantine.addActionListener(anaPencere);
			miDiophantine.setSelected(true);
		}
		return miDiophantine;
	}

	private JMenuItem getMITSP() {
		if (miTSP == null) {
			miTSP = new JRadioButtonMenuItem(AnaPencere.TSP);
			miTSP.setActionCommand(AnaPencere.TSP);
			miTSP.addActionListener(anaPencere);
		}
		return miTSP;
	}

	private JMenuItem getMIFinans() {
		if (miFinans == null) {
			miFinans = new JRadioButtonMenuItem(AnaPencere.FINANS);
			miFinans.setActionCommand(AnaPencere.FINANS);
			miFinans.addActionListener(anaPencere);
		}
		return miFinans;
	}

	private JMenuItem getMICikis() {
		if (miCikis == null) {
			miCikis = new JMenuItem("Çıkış");
			miCikis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return miCikis;
	}
}
