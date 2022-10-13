package TeaGasSys.InternetConnection;

public class Ethernet implements Internet{
    @Override
    public void connect() {
        System.out.println("Connected via Ethernet");
    }
}