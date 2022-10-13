import java.time.LocalDate;
import java.text.NumberFormat;


abstract class Account extends Person{
    private LocalDate openingDate;
    private float balance;
    private float loanAmount;
    private AccountStatus status;
    private float requestedLoan;

    abstract void withdraw(float amount);


    Account() {}

    Account(String name, float initBalance) {
        super(name);
        this.balance = initBalance;
        this.loanAmount = 0;
        this.requestedLoan = 0;
        this.status = AccountStatus.ACTIVE;
        this.openingDate = LocalDate.now();
    }

    public void deposit(float amount) {
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

        this.balance += amount;
        System.out.println(myFormat.format(amount) + "$ deposited; current balance " + myFormat.format(this.balance) + "$");
    }

    public Pair query() {
        return new Pair(balance, loanAmount);
    }

    public void loanRequest(float amount) {
        requestedLoan += amount;
        System.out.println("Loan request successful, sent for approval");
    }



    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setRequestedLoan( float amount) {
        requestedLoan = amount;
    }

    public float getRequestedLoan() {
        return this.requestedLoan;
    }
}
