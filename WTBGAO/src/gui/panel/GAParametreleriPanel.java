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
	private JLabel jLabel = null;
	private JTextField txtBireySayisi = null;
	private JLabel jLabel1 = null;
	private JTextField txtNesilSayisi = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel6 = null;
	private JTextField txtCaprazlamaOlasiligi = null;
	private JLabel jLabel7 = null;
	private JTextField txtMutasyonOlasiligi = null;
	private JLabel jLabel8 = null;
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
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(17, 113, 191, 16));
		jLabel8.setText("Elitizm");
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(0, 70, 151, 21));
		jLabel7.setText("Mutasyon Olasılığı:");
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(0, 50, 151, 21));
		jLabel6.setText("Çaprazlama Olasılığı:");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(0, 90, 151, 21));
		jLabel2.setText("Seçilim Yöntemi");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(0, 30, 151, 21));
		jLabel1.setToolTipText("Ulaşılması gereken nesil sayısı");
		jLabel1.setText("Nesil Sayısı:");
		jLabel = new JLabel();
		jLabel.setText("Birey Sayısı:");
		jLabel.setSize(new Dimension(151, 21));
		jLabel.setToolTipText("Toplumdaki birey sayısı");
		jLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		jLabel.setHorizontalAlignment(SwingConstants.LEADING);
		jLabel.setLocation(new Point(0, 10));
		this.setSize(231, 133);
		this.setLayout(null);
		this.add(jLabel, null);
		this.add(getTxtBireySayisi(), null);
		this.add(jLabel1, null);
		this.add(getTxtNesilSayisi(), null);
		this.add(jLabel2, null);
		this.add(jLabel6, null);
		this.add(getTxtCaprazlamaOlasiligi(), null);
		this.add(jLabel7, null);
		this.add(getTxtMutasyonOlasiligi(), null);
		this.add(jLabel8, null);
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
			txtBireySayisi = new JTextField();
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
			txtNesilSayisi = new JTextField();
			txtNesilSayisi.setBounds(new Rectangle(150, 50, 71, 21));
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
			txtCaprazlamaOlasiligi = new JTextField();
			txtCaprazlamaOlasiligi.setBounds(new Rectangle(150, 30, 71, 21));
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
			txtMutasyonOlasiligi = new JTextField();
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
		}
		return jrbElitizm;
	}
	
	public GAParametreler getParametreler(){
		//TODO parametreler swing sahalardan alinip dondurulecek
		return null;
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
