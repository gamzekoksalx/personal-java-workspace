package simpleinheritance;

/**
 * Test class for the CheckingAccount class.
 * Demonstrates deposits, withdrawals, overdraft handling, and account display.
 */
public class CheckingAccountTest {
    public static void main(String[] args) {
        // Create a CheckingAccount object
        CheckingAccount myAccount = new CheckingAccount();

        // Set account details (all values valid)
        myAccount.setFirstName("Gamze");
        myAccount.setLastName("Köksal");
        myAccount.setAccountID(2025);
        myAccount.setInterestRate(1.2);

        // Test deposit
        double depositAmount = 500;
        if (depositAmount >= 0) { // validation before calling deposit
            myAccount.deposit(depositAmount);
            System.out.println("Current balance after deposit: " + myAccount.getBalance());
        }

        // Test normal withdrawal
        double withdrawAmount1 = 100;
        if (withdrawAmount1 >= 0) {
            myAccount.processWithdrawal(withdrawAmount1);
            System.out.println("Balance after withdrawal of " + withdrawAmount1 + ": " + myAccount.getBalance());
        }

        // Test overdraft (withdraw more than balance)
        double withdrawAmount2 = 450;
        if (withdrawAmount2 >= 0) {
            myAccount.processWithdrawal(withdrawAmount2); // will trigger overdraft fee
            System.out.println("Balance after overdraft attempt: " + myAccount.getBalance());
        }

        // Test getInterestRate
        System.out.println("Retrieved interest rate: " + myAccount.getInterestRate());

        // Display full account details
        myAccount.displayAccount();
    }
}