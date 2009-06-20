package gui.panel;

import gui.AnaPencere;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class DugmelerPanel extends JPanel {

	public static final long serialVersionUID = 1L;
	public JButton jButton = null;
	public JButton jbDuraklat = null;
	public JButton jbDurdur = null;
	public JButton jbAdim = null;

	private AnaPencere anaPencere;

	/**
	 * This is the default constructor
	 * 
	 * @param anaPencere
	 */
	public DugmelerPanel(AnaPencere anaPencere) {
		super();
		this.anaPencere = anaPencere;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */

	public void initialize() {
		this.setLayout(null);
		this.setBounds(0, 0, 279, 32);
		this.add(getJButton(), null);
		this.add(getJbDuraklat(), null);
		this.add(getJbDurdur(), null);
		this.add(getJbAdim(), null);
		this.setVisible(true);
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setPreferredSize(new Dimension(80, 40));
			jButton.setLocation(new Point(0, 0));
			jButton.setSize(new Dimension(76, 16));
			jButton.setIcon(new ImageIcon("resimler/Play24.gif"));
			jButton.setMnemonic(KeyEvent.VK_B);
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					anaPencere.gaIslem(AnaPencere.BASLAT);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJbDuraklat() {
		if (jbDuraklat == null) {
			jbDuraklat = new JButton();
			jbDuraklat.setText("");
			jbDuraklat.setBounds(new Rectangle(75, 0, 74, 16));
			jbDuraklat.setIcon(new ImageIcon("resimler/Pause24.gif"));
			jbDuraklat.setPreferredSize(new Dimension(20, 20));
			jbDuraklat.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					anaPencere.gaIslem(AnaPencere.DURAKLAT);
				}
			});
		}
		return jbDuraklat;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJbDurdur() {
		if (jbDurdur == null) {
			jbDurdur = new JButton();

			jbDurdur.setLocation(new Point(210, 0));
			jbDurdur.setSize(new Dimension(63, 16));
			jbDurdur.setIcon(new ImageIcon("resimler/Stop24.gif"));
			jbDurdur.setPreferredSize(new Dimension(20, 20));
			jbDurdur.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					anaPencere.gaIslem(AnaPencere.DURDUR);
				}
			});
		}
		return jbDurdur;
	}

	public JButton getJbAdim() {
		if (jbAdim == null) {
			jbAdim = new JButton();

			jbAdim.setPreferredSize(new Dimension(50, 50));
			jbAdim.setLocation(new Point(150, 0));
			jbAdim.setIcon(new ImageIcon("resimler/StepForward24.gif"));
			jbAdim.setSize(new Dimension(68, 16));
			jbAdim.setSelected(true);
			jbAdim.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					anaPencere.gaIslem(AnaPencere.ADIM);
				}
			});
		}
		return jbAdim;
	}

} // @jve:decl-index=0:visual-constraint="191,121"

