import  java.time.LocalDate;

public class Savings extends Account{

    public static float interestRate;

    Savings(){}

    Savings(String name, float initBalance) {
        super(name, initBalance);
    }

    @Override
    public void loanRequest(float amount) {
        if (amount > 10000) {
            System.out.println("Loan amount must not exceed 10000$");
        }
        else super.loanRequest(amount);
    }

    @Override
    public void withdraw(float amount) {
        if (super.getBalance() - amount < 1000) {
            System.out.println("Account balance must not be below 1000$ after withdraw");
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
