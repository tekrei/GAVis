package ui.panel.j2d;

import ga.data.Chromosome;

import javax.swing.*;

public abstract class Java2D extends JInternalFrame {
    Java2D(String s) {
        super(s, true, false, true, true);
    }

    public abstract void update(Chromosome chr);
}