package gui;

import javax.swing.*;

/**
 * A minimal Java Swing-based Bank Balance GUI application.
 * Lets users deposit, withdraw, and view balance.
 */
public class BankAppGUI {
    /** Stores the current account balance */
    static double balance = 0;

    /** Label to display current balance */
    static JLabel balanceLabel;

    /** Text field for user to enter amount */
    static JTextField amountField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank App");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        balanceLabel = new JLabel("Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        amountField = new JTextField(10);
        amountField.setMaximumSize(amountField.getPreferredSize());
        amountField.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");
        exitBtn.setAlignmentX(JButton.CENTER_ALIGNMENT);

        depositBtn.addActionListener(e -> deposit());
        withdrawBtn.addActionListener(e -> withdraw());
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Final Balance: $" + balance);
            System.exit(0);
        });

        JPanel buttonRow = new JPanel();
        buttonRow.add(withdrawBtn);
        buttonRow.add(depositBtn);

        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(buttonRow);
        panel.add(exitBtn);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /** Adds the entered amount to the balance and updates the label. */
    public static void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            balance += amount;
            balanceLabel.setText("Balance: $" + balance);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Subtracts the entered amount from the balance and updates the label. */
    public static void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            balance -= amount;
            balanceLabel.setText("Balance: $" + balance);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}