package gui.panel;

import java.awt.GridBagLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class CizimPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * This is the default constructor
	 */
	public CizimPanel() {
		super("Görselleştirme Ekranı",
		          true, //resizable
		          false, //closable
		          true, //maximizable
		          true);//iconifiable
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
	}

}  //  @jve:decl-index=0:visual-constraint="43,27"
