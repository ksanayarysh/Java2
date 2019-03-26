package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatWindow extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JTextArea jTextArea;
    private JTextField textField;
    private JPanel jPanel;
    private JButton sendButton;

    private void createMenu() {
        jMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        jMenuBar.add(fileMenu);
        helpMenu = new JMenu("Help");
        jMenuBar.add(helpMenu);

        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemSaveAs = new JMenuItem("Save as");

        fileMenu.add(menuItemOpen);
        fileMenu.add(menuItemSaveAs);
    }

    private void createContent() {
        jPanel = new JPanel();
        JLabel label = new JLabel("Enter your text");
        textField = new JTextField(10);
        sendButton = new JButton("Send");
        JButton clearButton = new JButton("Clear");

        sendButton.addActionListener(e -> {
            String text = jTextArea.getText() + " \n";
            text = text.concat(textField.getText());
            jTextArea.setText(text);
            textField.setText("");
        });


        clearButton.addActionListener(e -> textField.setText(""));

        jPanel.add(label);
        jPanel.add(textField);
        jPanel.add(sendButton);
        jPanel.add(clearButton);

        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
    }

    private void setElementPositions() {
        this.getContentPane().add(BorderLayout.NORTH, jMenuBar);
        this.getContentPane().add(BorderLayout.CENTER, jTextArea);
        this.getContentPane().add(BorderLayout.SOUTH, jPanel);
    }

    public ChatWindow() throws HeadlessException {
        setTitle("Chat Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);

        createMenu();
        createContent();
        setElementPositions();

        getRootPane().setDefaultButton(sendButton);

        setVisible(true);
    }
}

class MainClass {
    public static void main(String[] args) {
        new ChatWindow();
    }
}

