package ui.panel.j2d;

import ga.data.Chromosome;
import ga.utility.Parameters;

import javax.swing.*;
import java.awt.*;

public class Diophantine2D extends Java2D {
    private JLabel lblInfo;

    public Diophantine2D() {
        super("Diophantine Problem", true, false, true, true);
        this.setLayout(new BorderLayout());
        this.setSize(300, 200);
        StringBuilder builder = new StringBuilder("EQUATION → ");
        for (int i = 0; i < Parameters.VALUES.length - 1; i++) {
            builder.append(Parameters.VALUES[i]).append("*").append("C[").append(i).append("] +");
        }
        builder.deleteCharAt(builder.length() - 1).append(" = ").append(Parameters.VALUES[Parameters.VALUES.length - 1]);
        this.add(new JLabel(builder.toString()), BorderLayout.NORTH);
        lblInfo = new JLabel();
        this.add(lblInfo, BorderLayout.CENTER);
    }

    @Override
    public void update(Chromosome chr) {
        int[] genes = chr.getGenes();
        StringBuilder label = new StringBuilder();
        label.append(" CURRENT BEST → ");
        int total = 0;
        for (int i = 0; i < genes.length; i++) {
            label.append(Parameters.VALUES[i]).append("*").append(genes[i]).append("+");
            total += genes[i] * Parameters.VALUES[i];
        }
        label.deleteCharAt(label.length() - 1).append(" = ").append(total);
        lblInfo.setText(label.toString());
    }
}
