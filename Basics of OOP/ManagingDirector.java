public class ManagingDirector extends Employee {

    ManagingDirector(){}
    ManagingDirector(String name) {
        super(name);
    }

    @Override
    public void lookupAccount(Object obj) {
        super.lookupAccount(obj);
    }

    @Override
    public void approveLoan(Object obj) {
        super.approveLoan(obj);
    }

    public void changeInterestRate(String type, float interest) {
        if (type.equalsIgnoreCase("Student")) {
            Student.interestRate = interest / 100;
            System.out.println("New interest rate for Student account: " + Student.interestRate * 100 + "%");
        }
        else if (type.equalsIgnoreCase("Savings")) {
            Savings.interestRate = interest / 100;
            System.out.println("New interest rate for Savings account: " + Savings.interestRate * 100 + "%");
        }
        else if (type.equalsIgnoreCase("FixedDeposit")) {
            FixedDeposit.interestRate = interest / 100;
            System.out.println("New interest rate for FixedDeposit account: " + FixedDeposit.interestRate * 100 + "%");
        }
        else System.out.println("Invalid Account type!");
    }
}
