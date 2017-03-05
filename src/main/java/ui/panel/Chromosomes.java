package ui.panel;


import ga.data.Chromosome;
import ui.component.ChromosomeTable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Chromosomes extends JInternalFrame {
    private final ChromosomeTable jct;

    public Chromosomes() {
        super("Chromosome List", true, false, true, true);
        this.setLayout(new BorderLayout());
        jct = new ChromosomeTable();
        JScrollPane jsp = new JScrollPane(jct);
        this.add(jsp, BorderLayout.CENTER);
        setVisible(true);
    }

    public void refreshData(List<Chromosome> _chromosomes) {
        jct.refreshData(_chromosomes);
    }

}
