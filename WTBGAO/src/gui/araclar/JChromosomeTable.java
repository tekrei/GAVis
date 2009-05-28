package gui.araclar;


import java.util.List;

import javax.swing.JTable;

public class JChromosomeTable extends JTable {
	private static final long serialVersionUID = 1L;

	public JChromosomeTable(List population) {
		super(new PopulationTableModel(population));
	}
	
	public void refreshData(List _kromozomlar) {
		try {
			((PopulationTableModel) getModel()).setData(_kromozomlar);
			updateUI();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
