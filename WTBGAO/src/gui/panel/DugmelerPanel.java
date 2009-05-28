package gui.panel;

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
	public JButton jButton1 = null;
	public JButton jButton2 = null;
	public JButton jButton3 = null;

	/**
	 * This is the default constructor
	 */
	public DugmelerPanel() {
		super();
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
		this.add(getJButton1(), null);
		this.add(getJButton2(), null);
		this.add(getJButton3(), null);
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
					System.out.println("Başlat!");
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
	public JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("");
			jButton1.setBounds(new Rectangle(75, 0, 74, 16));
			jButton1.setIcon(new ImageIcon("resimler/Pause24.gif"));
			jButton1.setPreferredSize(new Dimension(20, 20));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Duraklat!");
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();

			jButton2.setLocation(new Point(210, 0));
			jButton2.setSize(new Dimension(63, 16));
			jButton2.setIcon(new ImageIcon("resimler/Stop24.gif"));
			jButton2.setPreferredSize(new Dimension(20, 20));
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Durdur");
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();

			jButton3.setPreferredSize(new Dimension(50, 50));
			jButton3.setLocation(new Point(150, 0));
			jButton3.setIcon(new ImageIcon("resimler/StepForward24.gif"));
			jButton3.setSize(new Dimension(68, 16));
			jButton3.setSelected(true);
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO
					// Auto-generated
					// Event stub
					// actionPerformed()
				}
			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */

} // @jve:decl-index=0:visual-constraint="191,121"

