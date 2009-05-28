package gui.panel;


import gui.araclar.JChromosomeTable;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

public class KromozomPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private List kromozomListesi;
	private JChromosomeTable jct;

	/**
	 * This is the default constructor
	 */
	public KromozomPanel(List _kromozomListesi) {
		super("Kromozom Listesi",
		          true, //resizable
		          false, //closable
		          true, //maximizable
		          true);//iconifiable

		this.kromozomListesi = _kromozomListesi;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		jct = new JChromosomeTable(kromozomListesi);
		JScrollPane jsp = new JScrollPane(jct);
		this.add(jsp,BorderLayout.CENTER);
	}
	
	public void refreshData(List _kromozomList){
		jct.refreshData(_kromozomList);
	}

}
