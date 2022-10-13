import  java.time.LocalDate;

public class FixedDeposit extends Account{

    public static float interestRate;

    FixedDeposit(){}

    FixedDeposit(String name, float initBalance) {
        super(name, initBalance);
    }

    @Override
    public void deposit(float amount) {
        if (amount < 50000) {
            System.out.println("Deposit amount must be greater than 50,000$");
        }
        else {
            super.setBalance(super.getBalance() + amount);
        }
    }

    @Override
    public void loanRequest(float amount) {
        if (amount > 100000) {
            System.out.println("Loan amount must not exceed 100,000$");
        }
        else super.loanRequest(amount);
    }

    @Override
    public void withdraw(float amount) {
        if (TimeCount.globalTime < 1) {
            System.out.println("Your account must be more than one year old to withdraw money.");
        }
        else if (amount > super.getBalance()) {
            System.out.println("Withdrawal amount exceeded your account balance");

        }
        else {
            super.setBalance(super.getBalance() - amount);
            System.out.println("Successful withdrawal of " + amount +
                    "$. Your current balance is: " + super.getBalance() + "$");
        }

    }
}
