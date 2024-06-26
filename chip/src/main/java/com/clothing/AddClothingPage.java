package com.clothing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddClothingPage extends JPanel {
    private MainApp mainApp;

    public AddClothingPage(MainApp mainApp) {
        this.mainApp = mainApp;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField seasonField = new JTextField();
        JTextField typeField = new JTextField();
        JTextField categoryField = new JTextField();

        inputPanel.add(new JLabel("옷 이름:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("색상:"));
        inputPanel.add(colorField);
        inputPanel.add(new JLabel("계절:"));
        inputPanel.add(seasonField);
        inputPanel.add(new JLabel("종류:"));
        inputPanel.add(typeField);
        inputPanel.add(new JLabel("카테고리:"));
        inputPanel.add(categoryField);

        JButton addButton = new JButton("추가");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String color = colorField.getText();
            String season = seasonField.getText();
            String type = typeField.getText();
            String category = categoryField.getText();

            MainApp.getDatabaseManager().addClothing(new Clothing(0, name, color, season, type, category));
            JOptionPane.showMessageDialog(this, "옷이 추가되었습니다!", "추가 완료", JOptionPane.INFORMATION_MESSAGE);
            mainApp.showClosetPage();
        });

        JButton backButton = new JButton("메인 화면으로 돌아가기");
        backButton.addActionListener(e -> mainApp.showMainPage());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);

        add(new JLabel("옷 추가", JLabel.CENTER), BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
