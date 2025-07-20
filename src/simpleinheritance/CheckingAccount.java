package simpleinheritance;

// Subclass: CheckingAccount
public class CheckingAccount extends BankAccount {
    // Interest rate field
    private double interestRate;

    // Setter
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter
    public double getInterestRate() {
        return interestRate;
    }

    // Withdrawal that allows overdraft and charges fee if balance is negative
    public void processWithdrawal(double amount) {
        withdrawal(amount);
        if (getBalance() < 0) {
            withdrawal(30); // overdraft fee
            System.out.println("Overdraft: $30 fee has been accessed.");
        }
    }

    // Shows account info and interest rate
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate);
    }
}