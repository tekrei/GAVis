package gui;

import gui.panel.CizimPanel;
import gui.panel.DugmelerPanel;
import gui.panel.GAParametreleriPanel;
import gui.panel.IslemlerListesiPanel;
import gui.panel.KromozomPanel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AnaPencere extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktop = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	public AnaPencere() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(800, 600);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Genetik Algoritma Öğreticisi");
	}

	private JDesktopPane getJContentPane() {
		if (desktop == null) {
			desktop = new JDesktopPane();
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);


			desktop.setLayout(null);

			CizimPanel cp = new CizimPanel();
			cp.setVisible(true);
			cp.setBounds(new Rectangle(0, 0, 466, 411));
			desktop.add(cp);

			DugmelerPanel dp = new DugmelerPanel();
			dp.setBounds(new Rectangle(470, 510, 311, 16));
			desktop.add(dp);

			GAParametreleriPanel gap = new GAParametreleriPanel();
			gap.setVisible(true);
			gap.setBounds(new Rectangle(0, 410, 226, 136));
			desktop.add(gap);

			IslemlerListesiPanel il = new IslemlerListesiPanel();
			il.setBounds(new Rectangle(470, 285, 310, 226));
			il.setToolTipText("İşlemler Listesi");
			desktop.add(il);

			KromozomPanel kt = new KromozomPanel(null);
			kt.setVisible(true);
			kt.setBounds(new Rectangle(470, 0, 311, 286));
			desktop.add(kt);
		}
		return desktop;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu("Problem");
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getJMenuItem2());
			jMenu.add(getJMenuItem3());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem("Diophantine");
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem("TSP");
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem("Problem 3");
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem("Çıkış");
			jMenuItem3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
		}
		return jMenuItem3;
	}

	public static void main(String[] args) {
		(new AnaPencere()).setVisible(true);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
