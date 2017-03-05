package ui.panel.j2d;

import ga.data.Chromosome;

import javax.swing.*;
import java.awt.*;

public class Finance2D extends Java2D {

    public Finance2D() {
        super("Finance2D Problem",
                true, false, true, true);
        initialize();
    }

    private void initialize() {
        this.setSize(300, 200);
        this.setLayout(new BorderLayout());
        JLabel lblInfo = new JLabel();
        this.add(lblInfo, BorderLayout.CENTER);
    }

    @Override
    public void update(Chromosome chr) {
        // TODO how to visualise finance problem
    }

}
