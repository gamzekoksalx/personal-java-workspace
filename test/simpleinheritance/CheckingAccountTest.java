package simpleinheritance;

public class CheckingAccountTest {
    public static void main(String[] args) {
        // Create a CheckingAccount object
        CheckingAccount myAccount = new CheckingAccount();

        // Set account details
        myAccount.setFirstName("Gamze");
        myAccount.setLastName("Köksal");
        myAccount.setAccountID(2025);
        myAccount.setInterestRate(1.2);

        // Test deposit
        myAccount.deposit(500);
        System.out.println("Current balance after deposit: " + myAccount.getBalance());

        // Test normal withdrawal
        myAccount.processWithdrawal(100);
        System.out.println("Balance after withdrawal of 100: " + myAccount.getBalance());

        // Test overdraft
        myAccount.processWithdrawal(450); // will trigger overdraft fee
        System.out.println("Balance after overdraft attempt: " + myAccount.getBalance());

        // Test getInterestRate
        System.out.println("Retrieved interest rate: " + myAccount.getInterestRate());

        // Display full account details
        myAccount.displayAccount();
    }
}