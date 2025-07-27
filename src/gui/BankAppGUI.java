package gui;

import javax.swing.*;

/**
 * A minimal Java Swing-based Bank Balance GUI application.
 * Lets users deposit, withdraw, and view balance.
 */
public class BankAppGUI {
    /** Stores the current account balance */
    static double balance = 0;

    /**
     * Main method to launch the application window.
     */
    public static void main(String[] args) {
        /** Main application window */
        JFrame frame = new JFrame("Bank App");

        /** Main panel with vertical layout */
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        /** Label to display current balance */
        JLabel balanceLabel = new JLabel("Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        /** Text field for user to enter amount */
        JTextField amountField = new JTextField(10);
        amountField.setMaximumSize(amountField.getPreferredSize());
        amountField.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        /** Button to deposit funds */
        JButton depositBtn = new JButton("Deposit");

        /** Button to withdraw funds */
        JButton withdrawBtn = new JButton("Withdraw");

        /** Button to exit and show final balance */
        JButton exitBtn = new JButton("Exit");
        exitBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);

        /** Action: Add entered amount to balance */
        depositBtn.addActionListener(e -> {
            balance += Double.parseDouble(amountField.getText());
            balanceLabel.setText("Balance: $" + balance);
        });

        /** Action: Subtract entered amount from balance */
        withdrawBtn.addActionListener(e -> {
            balance -= Double.parseDouble(amountField.getText());
            balanceLabel.setText("Balance: $" + balance);
        });

        /** Action: Show final balance and close program */
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Final Balance: $" + balance);
            System.exit(0);
        });

        /** Panel for deposit and withdraw buttons side by side */
        JPanel buttonRow = new JPanel();
        buttonRow.add(withdrawBtn);
        buttonRow.add(depositBtn);

        /** Add all components to the main panel */
        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(buttonRow);
        panel.add(exitBtn);

        /** Add panel to window and show GUI */
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}