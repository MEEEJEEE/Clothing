package com.clothing;

import javax.swing.*;
import java.awt.*;

public class CoordinationPage extends JPanel {
    private MainApp mainApp;

    public CoordinationPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout(10, 10));

        JButton backButton = new JButton("Back to Main");
        backButton.addActionListener(e -> mainApp.showMainPage());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        buttonPanel.add(backButton);

        add(new JLabel("Coordination Page", JLabel.CENTER), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
