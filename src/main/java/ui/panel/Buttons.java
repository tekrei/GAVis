package ui.panel;

import ui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Buttons extends JInternalFrame {

    public static final long serialVersionUID = 1L;
    private final MainWindow mainWindow;

    public Buttons(MainWindow mainWindow) {
        super("Buttons", false, false, false, true);
        this.mainWindow = mainWindow;
        initialize();
    }

    private void initialize() {
        this.setLayout(new FlowLayout());
        this.add(getJButton());
        this.add(getJbDuraklat());
        this.add(getJbDurdur());
        this.add(getJbAdim());
        this.setVisible(true);
    }

    private JButton getJButton() {
        JButton jButton = new JButton();
        jButton.setIcon(createImageIcon("/images/play.gif"));
        jButton.setMnemonic(KeyEvent.VK_B);
        jButton.setPreferredSize(new Dimension(40, 25));
        jButton.addActionListener(e -> mainWindow.gaIslem(MainWindow.BASLAT));
        return jButton;
    }

    private JButton getJbDuraklat() {
        JButton jbDuraklat = new JButton();
        jbDuraklat.setIcon(createImageIcon("/images/pause.gif"));
        jbDuraklat.setMnemonic(KeyEvent.VK_P);
        jbDuraklat.setPreferredSize(new Dimension(40, 25));
        jbDuraklat.addActionListener(e -> mainWindow.gaIslem(MainWindow.DURAKLAT));
        return jbDuraklat;
    }

    private JButton getJbDurdur() {
        JButton jbDurdur = new JButton();
        jbDurdur.setIcon(createImageIcon("/images/stop.gif"));
        jbDurdur.setMnemonic(KeyEvent.VK_S);
        jbDurdur.setPreferredSize(new Dimension(40, 25));
        jbDurdur.addActionListener(e -> mainWindow.gaIslem(MainWindow.DURDUR));
        return jbDurdur;
    }

    private JButton getJbAdim() {
        JButton jbAdim = new JButton();
        jbAdim.setIcon(createImageIcon("/images/step.gif"));
        jbAdim.setPreferredSize(new Dimension(40, 25));
        jbAdim.setSelected(true);
        jbAdim.addActionListener(e -> mainWindow.gaIslem(MainWindow.ADIM));
        return jbAdim;
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

} // @jve:decl-index=0:visual-constraint="191,121"
