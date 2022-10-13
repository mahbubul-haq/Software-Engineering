
public class Cashier extends Employee{
    Cashier() {}
    Cashier(String name) {
        super(name);
    }

    @Override
    public void lookupAccount(Object obj) {
        super.lookupAccount(obj);
    }

    @Override
    public void approveLoan(Object obj) {
        System.out.println("You don't have permission for this operation!");
    }

}
