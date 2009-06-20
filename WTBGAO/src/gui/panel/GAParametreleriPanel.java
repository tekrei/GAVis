package gui.panel;

import ga.data.GAParametreler;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GAParametreleriPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblBireySayisi = null;
	private JTextField txtBireySayisi = null;
	private JLabel lblNesilSayisi = null;
	private JTextField txtNesilSayisi = null;
	private JLabel lblSecilim = null;
	private JLabel lblCaprazlamaOlasiligi = null;
	private JTextField txtCaprazlamaOlasiligi = null;
	private JLabel lblMutasyonOlasiligi = null;
	private JTextField txtMutasyonOlasiligi = null;
	private JLabel lblElitizm = null;
	private JRadioButton jrbElitizm = null;
	private JComboBox cmbSecilimYontemi = null;
	/**
	 * This is the default constructor
	 */
	public GAParametreleriPanel() {
		super("Kromozom Listesi",
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
		//TODO dugmelerin ve etiketlerin yeri karismis
		lblElitizm = new JLabel();
		lblElitizm.setBounds(new Rectangle(17, 113, 191, 16));
		lblElitizm.setText("Elitizm");
		lblMutasyonOlasiligi = new JLabel();
		lblMutasyonOlasiligi.setBounds(new Rectangle(0, 70, 151, 21));
		lblMutasyonOlasiligi.setText("Mutasyon Olasılığı:");
		lblCaprazlamaOlasiligi = new JLabel();
		lblCaprazlamaOlasiligi.setBounds(new Rectangle(0, 50, 151, 21));
		lblCaprazlamaOlasiligi.setText("Çaprazlama Olasılığı:");
		lblSecilim = new JLabel();
		lblSecilim.setBounds(new Rectangle(0, 90, 151, 21));
		lblSecilim.setText("Seçilim Yöntemi");
		lblNesilSayisi = new JLabel();
		lblNesilSayisi.setBounds(new Rectangle(0, 30, 151, 21));
		lblNesilSayisi.setToolTipText("Ulaşılması gereken nesil sayısı");
		lblNesilSayisi.setText("Nesil Sayısı:");
		lblBireySayisi = new JLabel();
		lblBireySayisi.setText("Birey Sayısı:");
		lblBireySayisi.setSize(new Dimension(151, 21));
		lblBireySayisi.setToolTipText("Toplumdaki birey sayısı");
		lblBireySayisi.setHorizontalTextPosition(SwingConstants.LEADING);
		lblBireySayisi.setHorizontalAlignment(SwingConstants.LEADING);
		lblBireySayisi.setLocation(new Point(0, 10));
		this.setSize(231, 133);
		this.setLayout(null);
		this.add(lblBireySayisi, null);
		this.add(getTxtBireySayisi(), null);
		this.add(lblNesilSayisi, null);
		this.add(getTxtNesilSayisi(), null);
		this.add(lblSecilim, null);
		this.add(lblCaprazlamaOlasiligi, null);
		this.add(getTxtCaprazlamaOlasiligi(), null);
		this.add(lblMutasyonOlasiligi, null);
		this.add(getTxtMutasyonOlasiligi(), null);
		this.add(lblElitizm, null);
		this.add(getJrbElitizm(), null);
		this.add(getCmbSecilimYontemi(), null);
	}

	/**
	 * This method initializes txtBireySayisi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtBireySayisi() {
		if (txtBireySayisi == null) {
			txtBireySayisi = new JTextField("100");
			txtBireySayisi.setBounds(new Rectangle(150, 10, 71, 21));
		}
		return txtBireySayisi;
	}

	/**
	 * This method initializes txtNesilSayisi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNesilSayisi() {
		if (txtNesilSayisi == null) {
			txtNesilSayisi = new JTextField("100");
			txtNesilSayisi.setBounds(new Rectangle(150, 30, 71, 21));
		}
		return txtNesilSayisi;
	}

	/**
	 * This method initializes txtCaprazlamaOlasiligi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCaprazlamaOlasiligi() {
		if (txtCaprazlamaOlasiligi == null) {
			txtCaprazlamaOlasiligi = new JTextField("0.7");
			txtCaprazlamaOlasiligi.setBounds(new Rectangle(150, 50, 71, 21));
		}
		return txtCaprazlamaOlasiligi;
	}

	/**
	 * This method initializes txtMutasyonOlasiligi	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtMutasyonOlasiligi() {
		if (txtMutasyonOlasiligi == null) {
			txtMutasyonOlasiligi = new JTextField("0.1");
			txtMutasyonOlasiligi.setBounds(new Rectangle(150, 70, 71, 21));
		}
		return txtMutasyonOlasiligi;
	}

	/**
	 * This method initializes jrbElitizm	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJrbElitizm() {
		if (jrbElitizm == null) {
			jrbElitizm = new JRadioButton();
			jrbElitizm.setBounds(new Rectangle(2, 112, 21, 16));
			jrbElitizm.setSelected(true);
		}
		return jrbElitizm;
	}
	
	public void updateParameters(){
		GAParametreler.getInstance().setPopulationSize(Integer.parseInt(txtBireySayisi.getText()));
		GAParametreler.getInstance().setGenerationCount(Integer.parseInt(txtNesilSayisi.getText()));
		GAParametreler.getInstance().setMutationProbability(Float.parseFloat(txtMutasyonOlasiligi.getText()));
		GAParametreler.getInstance().setCrossoverProbability(Float.parseFloat(txtCaprazlamaOlasiligi.getText()));
		//TODO elitism?
	}
	
	public void setParametreler(GAParametreler gap){
		//TODO parametreler sahalara yuklenecek
	}
	/**
	 * This method initializes cmbSecilimYontemi	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbSecilimYontemi() {
		if (cmbSecilimYontemi == null) {
			cmbSecilimYontemi = new JComboBox();
			cmbSecilimYontemi.setBounds(new Rectangle(150, 90, 71, 21));
		}
		return cmbSecilimYontemi;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
