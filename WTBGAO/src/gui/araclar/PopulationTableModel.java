package gui.araclar;

import ga.data.Chromosome;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PopulationTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] headers = { "ID", "Genes", "Value" };
	List kromozomlar;
	int row;

	/** Creates a new instance of TableModel */
	public PopulationTableModel(List dizi) {
		if (dizi == null)
			dizi = new ArrayList();
		this.kromozomlar = dizi;
	}

	public void removeAllRows() {
		for (int i = this.getRowCount(); i > 0; --i)
			kromozomlar.remove(i - 1);
	}

	public void setData(List _kromozomlar) {
		this.kromozomlar = _kromozomlar;
	}

	public int getColumnCount() {
		return headers.length;
	}

	public int getRowCount() {
		return this.kromozomlar.size();
	}

	public String getValueAt(int rowIndex, int columnIndex) {
		Chromosome chr = (Chromosome) kromozomlar.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return "" + rowIndex;
		case 1:
			return genesToStr(chr.getGenes());
		case 2:
			return Double.toString(chr.getFitness());
		default:
			return chr.toString();
		}
	}

	private String genesToStr(int[] genes) {
		String str = "";
		for (int i = 0; i < genes.length; i++) {
			str += genes[i] + "|";
		}
		return str.substring(0, str.length() - 1);
	}

	public String getColumnName(int i) {
		return headers[i];
	}
}
