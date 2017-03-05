package ui.component;


import ga.data.Chromosome;

import javax.swing.*;
import java.util.List;

public class ChromosomeTable extends JTable {
    private final PopulationTableModel mdlPopulation;

    public ChromosomeTable() {
        mdlPopulation = new PopulationTableModel();
        super.setModel(mdlPopulation);
        getColumnModel().getColumn(0).setPreferredWidth(20);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //TODO show on diagram when clicked, if GA is finished
        getSelectionModel().addListSelectionListener(e -> System.out.println(mdlPopulation.getChromosome(getSelectedRow())));
    }

    public void refreshData(List<Chromosome> _chromosomes) {
        try {
            mdlPopulation.updateData(_chromosomes);
            updateUI();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
