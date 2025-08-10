package simpleinheritance;

/**
 * Represents a checking account with an interest rate and overdraft handling.
 */
public class CheckingAccount extends BankAccount {
    // Interest rate for the account
    private double interestRate;

    /**
     * Sets the interest rate.
     * @param interestRate must be non-negative
     * @throws IllegalArgumentException if interestRate is negative
     */
    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
        this.interestRate = interestRate;
    }

    /** @return the interest rate */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Processes a withdrawal, allowing overdraft.
     * Charges a $30 fee if the balance goes negative.
     * @param amount amount to withdraw (must be non-negative)
     * @throws IllegalArgumentException if amount is negative
     */
    public void processWithdrawal(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        withdrawal(amount);
        if (getBalance() < 0) {
            withdrawal(30); // overdraft fee
            System.out.println("Overdraft: $30 fee has been accessed.");
        }
    }

    /**
     * Displays account summary including interest rate.
     */
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate);
    }
}