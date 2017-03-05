package ui.panel.j2d;

import ga.data.Chromosome;

import javax.swing.*;

public abstract class Java2D extends JInternalFrame {
    Java2D(String s, boolean b, boolean c, boolean d, boolean e) {
        super(s, b, c, d, e);
    }

    public abstract void update(Chromosome chr);
}