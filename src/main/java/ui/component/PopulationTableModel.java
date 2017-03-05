package ui.component;

import ga.data.Chromosome;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

class PopulationTableModel extends AbstractTableModel {
    private final String[] headers;
    private List<Chromosome> chromosomes;

    PopulationTableModel() {
        chromosomes = new ArrayList<>();
        headers = new String[]{"ID", "Genes", "Fitness"};
    }

    void updateData(List<Chromosome> _chromosomes) {
        this.chromosomes = _chromosomes;
    }

    public int getColumnCount() {
        return headers.length;
    }

    public int getRowCount() {
        return chromosomes.size();
    }

    public Object getValueAt(int row, int column) {
        Chromosome chr = chromosomes.get(row);
        switch (column) {
            case 0:
                return row;
            case 1:
                return chr.getGenesAsString();
            case 2:
                return chr.getFitness();
            default:
                return chr;
        }
    }

    Chromosome getChromosome(int i) {
        return chromosomes.get(i);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public String getColumnName(int i) {
        return headers[i];
    }
}
