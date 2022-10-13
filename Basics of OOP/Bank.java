import java.util.ArrayList;
import java.time.LocalDate;
import java.text.NumberFormat;

class Quad{
    public Boolean first;
    public LoggedInStatus second;
    public int third;
    public String fourth;

    Quad(){}
    Quad(Boolean first, LoggedInStatus second, int third, String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}

public class Bank {
    private String code;
    private String name;
    private String address;
    private long internalFund;
    public ArrayList<Student> studentAcc;
    public ArrayList<Savings> savingsAcc;
    public ArrayList<FixedDeposit> fixedDepositAcc;
    private ArrayList<Officer> officers;
    private ArrayList<ManagingDirector> managingDirectors;
    private ArrayList<Cashier> cashiers;
    private LoggedInStatus loggedInStatus;///who logged IN
    private int loggedInIndex;///index in the respective account list

    Bank() {
        internalFund = 1000000;
        initialize();
        createInitialEmployees();
        loggedInStatus = LoggedInStatus.NONE;
    }

    Bank(String code, String name, String address, long internalFund) {
        this.address = address;
        this.name = name;
        this.internalFund = internalFund;
        this.code = code;
        loggedInStatus = LoggedInStatus.NONE;
        initialize();
        createInitialEmployees();
    }

    void initialize() {
        studentAcc = new ArrayList<Student>();
        savingsAcc = new ArrayList<>();
        fixedDepositAcc = new ArrayList<>();
        officers = new ArrayList<>();
        managingDirectors = new ArrayList<>();
        cashiers = new ArrayList<>();
        Student.interestRate = 0.05f;
        Savings.interestRate = 0.1f;
        FixedDeposit.interestRate = 0.15f;
    }

    public void createInitialEmployees() {
        managingDirectors.add(new ManagingDirector("MD"));
        officers.add(new Officer("S1"));
        officers.add(new Officer("S2"));
        for (int i = 1; i <= 5; i++) {
            String curName = "C" + i;
            cashiers.add(new Cashier(curName));
        }

    }

    public Quad searchAccountName(String newName) {
        for (int i = 0; i < studentAcc.size(); i++) {
            if (studentAcc.get(i).getName().equals(newName)) return new Quad(true, LoggedInStatus.STUDENT, i, newName);
        }
        for (int i = 0; i < savingsAcc.size(); i++) {
            if (savingsAcc.get(i).getName().equals(newName)) return new Quad(true, LoggedInStatus.SAVINGS, i, newName);
        }
        for (int i = 0; i < fixedDepositAcc.size(); i++) {
            if (fixedDepositAcc.get(i).getName().equals(newName)) return new Quad(true, LoggedInStatus.FIXED_DEPOSIT, i, newName);
        }
        for (int i = 0; i < managingDirectors.size(); i++) {
            if (managingDirectors.get(i).getName().equals(newName)) return new Quad(true, LoggedInStatus.MANAGING_DIRECTOR, i, newName);
        }
        for (int i = 0; i < cashiers.size(); i++) {
            if (cashiers.get(i).getName().equals(newName)) return new Quad(true, LoggedInStatus.CASHIER, i, newName);
        }
        for (int i = 0; i < officers.size(); i++) {
            if (officers.get(i).getName().equals(newName)) return new Quad(true, LoggedInStatus.OFFICER, i, newName);
        }

        return new Quad(false, LoggedInStatus.NONE, -1, "");
    }

    public void createAccount(String name, String type, float initBalance) {
        String accName;

        if (loggedInStatus != LoggedInStatus.NONE) {
            System.out.println("Invalid Command!");
            return;
        }

        if (searchAccountName(name).first) {
            System.out.println("Sorry, account Name already taken!");
            return;
        }
        else if (initBalance < 0) {
            System.out.println("Initial balance must be non-negative");
            return;
        }

        if (type.equalsIgnoreCase("Student")) {
            studentAcc.add(new Student(name, initBalance));
            accName = "Student";
            loggedInStatus = LoggedInStatus.STUDENT;
            loggedInIndex = studentAcc.size() - 1;
        }
        else if (type.equalsIgnoreCase("Savings")) {
            savingsAcc.add(new Savings(name, initBalance));
            accName = "Savings";
            loggedInIndex = savingsAcc.size() - 1;
            loggedInStatus = LoggedInStatus.SAVINGS;
        }
        else if (type.equalsIgnoreCase("FixedDeposit")) {
            if (initBalance < 100000) {
                System.out.println("Amount can't be less than 100,000$ for FixedDeposit account");
                return;
            }
            else {
                fixedDepositAcc.add(new FixedDeposit(name, initBalance));
                accName = "FixedDeposit";
                loggedInIndex = fixedDepositAcc.size() - 1;
                loggedInStatus = LoggedInStatus.FIXED_DEPOSIT;
            }
        }
        else {
            System.out.println("Invalid Account type!");
            return;
        }

        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

        System.out.print(accName + " account for " + name + " Created; ");
        System.out.println("initial balance " + myFormat.format((int) (initBalance + .1)) + "$");
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }

        if (loggedInStatus == LoggedInStatus.STUDENT) {
            studentAcc.get(loggedInIndex).deposit(amount);
        }
        else if (loggedInStatus == LoggedInStatus.SAVINGS) {
            savingsAcc.get(loggedInIndex).deposit(amount);
        }
        else if (loggedInStatus == LoggedInStatus.FIXED_DEPOSIT) {
            fixedDepositAcc.get(loggedInIndex).deposit(amount);
        }
        else {
            System.out.println("Invalid Command!");

        }
    }

    public void withdraw(float amount) {
        if (amount <= 1e-4) {
            System.out.println("Withdraw amount must be positive");
        }
        else if (loggedInStatus == LoggedInStatus.STUDENT) {
            studentAcc.get(loggedInIndex).withdraw(amount);
        }
        else if (loggedInStatus == LoggedInStatus.SAVINGS) {
            savingsAcc.get(loggedInIndex).withdraw(amount);
        }
        else if (loggedInStatus == LoggedInStatus.FIXED_DEPOSIT) {
            fixedDepositAcc.get(loggedInIndex).withdraw(amount);
        }
        else {
            System.out.println("Invalid command!");
        }

    }

    public void loanRequest(float amount) {
        if (amount <= 0) {
            System.out.println("Amount Must be positive!");
        }
        else if (amount >= internalFund) {
            System.out.println("Loan amount too big!");
        }
        else if (loggedInStatus == LoggedInStatus.SAVINGS) {
            savingsAcc.get(loggedInIndex).loanRequest(amount);
        }
        else if (loggedInStatus == LoggedInStatus.STUDENT) {
            studentAcc.get(loggedInIndex).loanRequest(amount);
        }
        else if (loggedInStatus == LoggedInStatus.FIXED_DEPOSIT) {
            fixedDepositAcc.get(loggedInIndex).loanRequest(amount);
        }
        else {
            System.out.println("Invalid command!");
        }
    }

    public void query() {

        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        Pair pair;



        if (loggedInStatus == LoggedInStatus.STUDENT || loggedInStatus == LoggedInStatus.SAVINGS
        || loggedInStatus == LoggedInStatus.FIXED_DEPOSIT) {

            if (loggedInStatus == LoggedInStatus.SAVINGS) {
                pair = savingsAcc.get(loggedInIndex).query();
            }
            else if (loggedInStatus == LoggedInStatus.STUDENT) {
                pair = studentAcc.get(loggedInIndex).query();
            }
            else {
                pair = fixedDepositAcc.get(loggedInIndex).query();
            }

            System.out.print("Current balance " + myFormat.format((int) pair.first) + "$");

            if (pair.second > 1e-4) {
                System.out.println(", loan " + myFormat.format((int) pair.second) + "$");
            }
            else System.out.println("");
        }
        else {
            System.out.println("Invalid Command!");
        }
    }

    public void lookupAccount(String name) {
        Quad user = searchAccountName(name);

        if (!(user.second == LoggedInStatus.STUDENT || user.second == LoggedInStatus.SAVINGS ||
        user.second == LoggedInStatus.FIXED_DEPOSIT)) {
            System.out.println("Invalid account name");
            return;
        }

        if (loggedInStatus == LoggedInStatus.OFFICER) {
            if (user.second == LoggedInStatus.SAVINGS) {
                officers.get(loggedInIndex).lookupAccount(savingsAcc.get(user.third));
            }
            else if (user.second == LoggedInStatus.FIXED_DEPOSIT) {
                officers.get(loggedInIndex).lookupAccount(fixedDepositAcc.get(user.third));
            }
            else officers.get(loggedInIndex).lookupAccount(studentAcc.get(user.third));
        }
        else if (loggedInStatus == LoggedInStatus.CASHIER) {
            if (user.second == LoggedInStatus.SAVINGS) {
                cashiers.get(loggedInIndex).lookupAccount(savingsAcc.get(user.third));
            }
            else if (user.second == LoggedInStatus.FIXED_DEPOSIT) {
                cashiers.get(loggedInIndex).lookupAccount(fixedDepositAcc.get(user.third));
            }
            else cashiers.get(loggedInIndex).lookupAccount(studentAcc.get(user.third));
        }
        else if (loggedInStatus == LoggedInStatus.MANAGING_DIRECTOR) {
            if (user.second == LoggedInStatus.SAVINGS) {
                managingDirectors.get(loggedInIndex).lookupAccount(savingsAcc.get(user.third));
            }
            else if (user.second == LoggedInStatus.FIXED_DEPOSIT) {
                managingDirectors.get(loggedInIndex).lookupAccount(fixedDepositAcc.get(user.third));
            }
            else managingDirectors.get(loggedInIndex).lookupAccount(studentAcc.get(user.third));
        }
        else {
            System.out.println("Invalid command!");
        }
    }

    public void showInternalFund() {
        if (loggedInStatus == LoggedInStatus.MANAGING_DIRECTOR) {
            System.out.println("Internal fund: " + internalFund + "$");
        }
        else {
            System.out.println("You don't have permission for this operation");
        }
    }

    public void changeInterestRate(String type, float amount) {

        if (amount < 0 && amount > 100) {
            System.out.println("This interest rate is not allowed!");
            return;
        }

        if (loggedInStatus != LoggedInStatus.MANAGING_DIRECTOR) {
            System.out.println("You don't have permission for this operation");
        }
        else {
            managingDirectors.get(loggedInIndex).changeInterestRate(type, amount);
        }
    }

    public void approveLoan() {
        if (loggedInStatus == LoggedInStatus.MANAGING_DIRECTOR) {
            managingDirectors.get(loggedInIndex).approveLoan(this);
        }
        else if (loggedInStatus == LoggedInStatus.OFFICER) {
            officers.get(loggedInIndex).approveLoan(this);
        }
        else {
            System.out.println("You don't have permission for this operation");
        }
    }

    public void openUser(String name) {

        if (loggedInStatus != LoggedInStatus.NONE) {
            System.out.println("Invalid command!");
            return;
        }

        Quad user = searchAccountName(name);
        loggedInStatus = user.second;
        loggedInIndex = user.third;

        if (loggedInStatus == LoggedInStatus.STUDENT || loggedInStatus == LoggedInStatus.SAVINGS
                || loggedInStatus == LoggedInStatus.FIXED_DEPOSIT) {
            System.out.println("Welcome back, " + user.fourth);
        }
        else if (loggedInStatus == LoggedInStatus.CASHIER || loggedInStatus == LoggedInStatus.MANAGING_DIRECTOR
                || loggedInStatus == LoggedInStatus.OFFICER) {
            System.out.print(user.fourth + " active");

            if (hasLoanRequest() && loggedInStatus != LoggedInStatus.CASHIER) {
                System.out.println(", there are loan approvals pending");
            }
            else System.out.println("");
        }
        else {
            System.out.println("No user with the name!");
        }

    }

    public boolean hasLoanRequest() {
        for (Student s: studentAcc) {
            if (s.getRequestedLoan() > 0)
                return true;
        }

        for (Savings s : savingsAcc) {
            if (s.getRequestedLoan() > 0)
                return true;
        }

        for (FixedDeposit fd : fixedDepositAcc) {
            if (fd.getRequestedLoan() > 0)
                return true;
        }
        return false;
    }

    public void close() {

        if (loggedInStatus == LoggedInStatus.FIXED_DEPOSIT) {
            System.out.println("Transaction Closed for " + fixedDepositAcc.get(loggedInIndex).getName());
        }
        else if (loggedInStatus == LoggedInStatus.SAVINGS) {
            System.out.println("Transaction Closed for " + savingsAcc.get(loggedInIndex).getName());
        }
        else if (loggedInStatus == LoggedInStatus.STUDENT) {
            System.out.println("Transaction Closed for " + studentAcc.get(loggedInIndex).getName());
        }
        else if (loggedInStatus == LoggedInStatus.CASHIER) {
            System.out.println("Operations for " + cashiers.get(loggedInIndex).getName() + " Closed");
        }
        else if (loggedInStatus == LoggedInStatus.MANAGING_DIRECTOR) {
            System.out.println("Operations for " + managingDirectors.get(loggedInIndex).getName() + " Closed");
        }
        else if (loggedInStatus ==  LoggedInStatus.OFFICER) {
            System.out.println("Operations for " + officers.get(loggedInIndex).getName() + " Closed");
        }
        else {
            System.out.println("Invalid Command!");
        }

        loggedInStatus = LoggedInStatus.NONE;
        loggedInIndex = -1;
    }

    public void incrementOneYear() {
        if (loggedInStatus != LoggedInStatus.NONE) {
            System.out.println("Invalid Command!");
            return;
        }

        updateYearStudent();
        updateYearSavings();
        updateYearFixedDeposit();

        TimeCount.globalTime += 1;
        System.out.println("1 year passed");
    }

    public void updateYearStudent() {



        for (int i = 0; i < studentAcc.size(); i++) {

            studentAcc.get(i).setBalance(studentAcc.get(i).getBalance() * (1 + Student.interestRate));


            float val = studentAcc.get(i).getLoanAmount() * 0.1f;
            float temp = val - studentAcc.get(i).getBalance();
            studentAcc.get(i).setBalance(Math.max(0, studentAcc.get(i).getBalance() - val));
            if (temp > 0) {
                studentAcc.get(i).setLoanAmount(studentAcc.get(i).getLoanAmount() + temp);
            }
        }
    }

    public void updateYearSavings() {
        for (int i = 0; i < savingsAcc.size(); i++) {

            savingsAcc.get(i).setBalance(savingsAcc.get(i).getBalance() * (1 + Savings.interestRate));

            float val = savingsAcc.get(i).getLoanAmount() * 0.1f + 500;
            float temp = val - savingsAcc.get(i).getBalance();
            savingsAcc.get(i).setBalance(Math.max(0, savingsAcc.get(i).getBalance() - val));
            if (temp > 0) {
                savingsAcc.get(i).setLoanAmount(savingsAcc.get(i).getLoanAmount() + temp);
            }
        }
    }

    public void updateYearFixedDeposit() {
        for (int i = 0; i < fixedDepositAcc.size(); i++) {

            fixedDepositAcc.get(i).setBalance(fixedDepositAcc.get(i).getBalance() * (1 + FixedDeposit.interestRate));

            float val = fixedDepositAcc.get(i).getLoanAmount() * 0.1f + 500;
            float temp = val - fixedDepositAcc.get(i).getBalance();
            fixedDepositAcc.get(i).setBalance(Math.max(0, fixedDepositAcc.get(i).getBalance() - val));
            if (temp > 0) {
                fixedDepositAcc.get(i).setLoanAmount(fixedDepositAcc.get(i).getLoanAmount() + temp);
            }
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getInternalFund() {
        return internalFund;
    }

    public void setInternalFund(long internalFund) {
        this.internalFund = internalFund;
    }

}
