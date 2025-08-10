package simpleinheritance;

/**
 * Represents a basic bank account with deposit and withdrawal functionality.
 */
public class BankAccount {
    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    /**
     * Creates a new bank account with a balance of 0.0.
     */
    public BankAccount() {
        balance = 0.0;
    }

    /**
     * Adds money to the balance.
     * @param amount amount to deposit (must be non-negative)
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        balance += amount;
    }

    /**
     * Subtracts money from the balance.
     * @param amount amount to withdraw (must be non-negative)
     * @throws IllegalArgumentException if amount is negative
     */
    public void withdrawal(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");
        }
        balance -= amount;
    }

    /** Sets the first name. */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Sets the last name. */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Sets the account ID. */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    /** @return first name */
    public String getFirstName() {
        return firstName;
    }

    /** @return last name */
    public String getLastName() {
        return lastName;
    }

    /** @return account ID */
    public int getAccountID() {
        return accountID;
    }

    /** @return current balance */
    public double getBalance() {
        return balance;
    }

    /**
     * Prints all account information.
     */
    public void accountSummary() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
    }
}