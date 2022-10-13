package TeaGasSys.InternetConnection;

public class Wifi implements Internet{
    @Override
    public void connect() {
        System.out.println("Connected via Wifi");
    }
}