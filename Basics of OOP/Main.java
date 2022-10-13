import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean isNumeric(String value) {
        boolean numeric = value.matches("-?\\d+(.\\d+)?");
        if (numeric) return true;
        else {
            System.out.println("Amount must be a number");
            return false;
        }
    }

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String query = scanner.nextLine();
            System.out.println(query);
            String []arr = query.split(" ");
            if (arr.length == 0) continue;

            if (arr[0].equalsIgnoreCase("Create")) {
                if (arr.length != 4) {
                    System.out.println("Invalid Command!");
                }
                else {
                    if (isNumeric(arr[3])) {
                        bank.createAccount(arr[1], arr[2], Float.parseFloat(arr[3]));
                    }
                }
            }
            else if (arr[0].equalsIgnoreCase("Query")) {
                bank.query();
            }
            else if(arr[0].equalsIgnoreCase("Deposit")) {
                if (arr.length != 2) {
                    System.out.println("Invalid command!");
                }
                else if (isNumeric(arr[1])) {
                    bank.deposit(Float.parseFloat(arr[1]));
                }
            }
            else if (arr[0].equalsIgnoreCase("Withdraw")) {
                if (arr.length != 2) {
                    System.out.println("Invalid command!");
                }
                else if (isNumeric(arr[1])) {
                    bank.withdraw(Float.parseFloat(arr[1]));
                }
            }
            else if (arr[0].equalsIgnoreCase("Close")) {
                bank.close();
            }
            else if (arr[0].equalsIgnoreCase("INC")) {
                bank.incrementOneYear();
            }
            else if (arr[0].equalsIgnoreCase("Request")) {
                if (arr.length == 2) {
                    if (isNumeric(arr[1])) {
                        bank.loanRequest(Float.parseFloat(arr[1]));
                    }
                    else System.out.println("Amount must be a number");
                }
                else System.out.println("Invalid Command!");
            }
            else if (arr[0].equalsIgnoreCase("Open")) {
                if (arr.length != 2) System.out.println("Invalid Command!");
                else {
                    bank.openUser(arr[1]);
                }
            }
            else if (query.equalsIgnoreCase("Approve Loan")) {
                bank.approveLoan();
            }
            else if (arr[0].equalsIgnoreCase("Change")) {
                if (arr.length == 3) {
                    if (isNumeric(arr[2])) {

                        bank.changeInterestRate(arr[1], Float.parseFloat(arr[2]));
                    }
                    else {
                        System.out.println("Invalid amount!");
                    }

                }
                else System.out.println("Invalid command!");
            }
            else if (query.equalsIgnoreCase("See")) {
                bank.showInternalFund();
            }
            else if (arr[0].equalsIgnoreCase("Lookup")) {
                if (arr.length == 2) {
                    bank.lookupAccount(arr[1]);
                }
                else System.out.println("Invalid command");
            }
            else {
                System.out.println("Invalid command!");
            }


        }



        scanner.close();
    }
}
