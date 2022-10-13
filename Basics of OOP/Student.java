import java.time.LocalDate;

public class Student extends Account {

    public static float interestRate;

    Student(){}

    Student(String name, float initBalance) {
        super(name, initBalance);
    }

    @Override
    public void loanRequest(float amount) {
        if (amount > 1000) {
            System.out.println("Loan amount must not exceed 1000$");
        }
        else super.loanRequest(amount);
    }

    @Override
    public void withdraw(float amount) {
        if (amount > 10000) {
            System.out.println("Withdrawal amount must not exceed 10,000$");
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
