package ui.component;

import ui.MainWindow;

import javax.swing.*;

public class MenuUtils {
    private final MainWindow mainWindow;
    private JMenuBar jJMenuBar = null;
    private JMenu jMenu = null;
    private JMenuItem miDiophantine = null;
    private JMenuItem miTSP = null;
    private JMenuItem miFinans = null;
    private JMenuItem miCikis = null;

    public MenuUtils(MainWindow _mainWindow) {
        this.mainWindow = _mainWindow;
    }

    public JMenuBar getJJMenuBar() {
        if (jJMenuBar == null) {
            jJMenuBar = new JMenuBar();
            jJMenuBar.add(getJMenu());
        }
        return jJMenuBar;
    }

    private JMenu getJMenu() {
        if (jMenu == null) {
            jMenu = new JMenu("Problem");
            ButtonGroup bg = new ButtonGroup();
            JMenuItem jmi = getMIDiophantine();
            bg.add(jmi);
            jMenu.add(jmi);
            jmi = getMITSP();
            bg.add(jmi);
            jMenu.add(jmi);
            jmi = getMIFinans();
            bg.add(jmi);
            jMenu.add(jmi);
            jmi = getMICikis();
            bg.add(jmi);
            jMenu.add(jmi);
        }
        return jMenu;
    }

    private JMenuItem getMIDiophantine() {
        if (miDiophantine == null) {
            miDiophantine = new JRadioButtonMenuItem(MainWindow.DIOPHANTINE);
            miDiophantine.setActionCommand(MainWindow.DIOPHANTINE);
            miDiophantine.addActionListener(mainWindow);
            miDiophantine.setSelected(true);
        }
        return miDiophantine;
    }

    private JMenuItem getMITSP() {
        if (miTSP == null) {
            miTSP = new JRadioButtonMenuItem(MainWindow.TSP);
            miTSP.setActionCommand(MainWindow.TSP);
            miTSP.addActionListener(mainWindow);
        }
        return miTSP;
    }

    private JMenuItem getMIFinans() {
        if (miFinans == null) {
            miFinans = new JRadioButtonMenuItem(MainWindow.FINANS);
            miFinans.setActionCommand(MainWindow.FINANS);
            miFinans.addActionListener(mainWindow);
        }
        return miFinans;
    }

    private JMenuItem getMICikis() {
        if (miCikis == null) {
            miCikis = new JMenuItem("Çıkış");
            miCikis.addActionListener(e -> System.exit(0));
        }
        return miCikis;
    }
}
