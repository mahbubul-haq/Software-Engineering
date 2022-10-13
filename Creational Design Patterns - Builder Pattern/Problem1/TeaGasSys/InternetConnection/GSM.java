package TeaGasSys.InternetConnection;

public class GSM implements Internet{
    @Override
    public void connect() {
        System.out.println("Connected via GSM");
    }
}