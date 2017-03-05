package ui.panel;

import javax.swing.*;
import java.awt.*;

public class Operations extends JInternalFrame {

    private final JTextArea txtMessages;

    public Operations() {
        super("Operations", true, false, true, true);
        this.setLayout(new BorderLayout());
        txtMessages = new JTextArea();
        txtMessages.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(txtMessages);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void addInfo(String info) {
        txtMessages.insert(info, 0);
    }
}
