import com.sun.xml.internal.ws.addressing.WsaTubeHelper;

import java.time.LocalDate;
import java.text.NumberFormat;

abstract class Employee extends Person{
    private LocalDate joinDate;
    private int salary;

    Employee() {}
    Employee(String name) {
        super(name);
    }

    public void lookupAccount(Object obj) {

        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

        if (obj instanceof Student) {
            Student student = (Student) obj;
            System.out.println(student.getName() + "'s current balance " + myFormat.format((int)(student.getBalance() + .5)) + "$");
        }
        else if (obj instanceof Savings) {
            Savings savings = (Savings) obj;
            System.out.println(savings.getName() + "'s current balance " + myFormat.format((int)(savings.getBalance() + .5)) + "$");
        }
        else if (obj instanceof FixedDeposit) {
            FixedDeposit fd = (FixedDeposit) obj;
            System.out.println(fd.getName() + "'s current balance " + myFormat.format((int)(fd.getBalance() + .5)) + "$");

        }
    }

    public void approveLoan(Object obj) {
        if (obj instanceof Bank) {
            Bank bank = (Bank) obj;

            for (Student s : bank.studentAcc) {
                if (s.getRequestedLoan() > 1e-4 && s.getRequestedLoan() <= bank.getInternalFund()) {
                    s.setLoanAmount(s.getLoanAmount() + s.getRequestedLoan());
                    bank.setInternalFund(bank.getInternalFund() -(long) s.getRequestedLoan());
                    s.setRequestedLoan(0);
                    System.out.println("Loan for " + s.getName() + " approved");
                }
            }
            for (Savings s : bank.savingsAcc) {
                if (s.getRequestedLoan() > 1e-4 && s.getRequestedLoan() <= bank.getInternalFund()) {
                    s.setLoanAmount(s.getLoanAmount() + s.getRequestedLoan());
                    bank.setInternalFund(bank.getInternalFund() -(long) s.getRequestedLoan());
                    s.setRequestedLoan(0);
                    System.out.println("Loan for " + s.getName() + " approved");
                }
            }
            for (FixedDeposit s : bank.fixedDepositAcc) {
                if (s.getRequestedLoan() > 1e-4 && s.getRequestedLoan() <= bank.getInternalFund()) {
                    s.setLoanAmount(s.getLoanAmount() + s.getRequestedLoan());
                    bank.setInternalFund(bank.getInternalFund() -(long) s.getRequestedLoan());
                    s.setRequestedLoan(0);
                    System.out.println("Loan for " + s.getName() + " approved");
                }
            }


        }
        else {
            System.out.println("Invalid Call!");
        }
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
