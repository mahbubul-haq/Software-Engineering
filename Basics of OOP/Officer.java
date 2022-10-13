public class Officer extends Employee{

    Officer() {}
    Officer(String name) {
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
}
