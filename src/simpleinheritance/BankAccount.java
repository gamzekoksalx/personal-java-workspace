package simpleinheritance;

// Superclass: BankAccount
public class BankAccount {
    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor: sets initial balance to 0
    public BankAccount() {
        balance = 0.0;
    }

    // Adds money to balance
    public void deposit(double amount) {
        balance += amount;
    }

    // Subtracts money from balance
    public void withdrawal(double amount) {
        balance -= amount;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Prints all account info
    public void accountSummary() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
    }
}