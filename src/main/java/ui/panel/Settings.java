package ui.panel;

import ga.utility.Parameters;
import ui.component.SpringUtilities;

import javax.swing.*;

public class Settings extends JInternalFrame {
    public Settings() {
        super("Parameter Settings", false, false, false, true);
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel(new SpringLayout());

        panel.add(new JLabel("Population size:"));
        JFormattedTextField txtBireySayisi = new JFormattedTextField(Parameters.populationSize);
        panel.add(txtBireySayisi);

        panel.add(new JLabel("Generation limit:"));
        JFormattedTextField txtNesilSayisi = new JFormattedTextField(Parameters.generationCount);
        panel.add(txtNesilSayisi);

        panel.add(new JLabel("Crossover probability:"));
        JFormattedTextField txtCaprazlamaOlasiligi = new JFormattedTextField("" + Parameters.crossoverProbability);
        panel.add(txtCaprazlamaOlasiligi);

        panel.add(new JLabel("Mutation probability:"));
        JFormattedTextField txtMutasyonOlasiligi = new JFormattedTextField("" + Parameters.mutationProbability);
        panel.add(txtMutasyonOlasiligi);

        JCheckBox jrbElitizm = new JCheckBox("Elitism");
        jrbElitizm.setSelected(Parameters.elitism);
        panel.add(jrbElitizm);

        JButton btnSave = new JButton("Update");
        btnSave.addActionListener(e -> {
            Parameters.populationSize = Integer.parseInt(txtBireySayisi.getText());
            Parameters.generationCount = Integer.parseInt(txtNesilSayisi.getText());
            Parameters.mutationProbability = Float.parseFloat(txtMutasyonOlasiligi.getText());
            Parameters.crossoverProbability = Float.parseFloat(txtCaprazlamaOlasiligi.getText());
            Parameters.elitism = jrbElitizm.isSelected();
        });
        panel.add(btnSave);
        SpringUtilities.makeCompactGrid(panel, 5, 2, 5, 5, 5, 5);
        this.setContentPane(panel);
        setVisible(true);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
