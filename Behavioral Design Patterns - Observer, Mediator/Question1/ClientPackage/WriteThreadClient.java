package ClientPackage;

import util.NetworkUtil;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    public Client client;

    public WriteThreadClient(Client client, NetworkUtil nc) {
        this.nc = nc;
        this.client = client;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                String s = input.nextLine();

                if (s.charAt(0) == 'S')
                {
                    StringTokenizer st = new StringTokenizer(s);
                    st.nextToken();
                    String temp = st.nextToken();
                    nc.write(client);
                    nc.write("S");
                    nc.write(temp);
                    nc.write(client.name + " subscribed stock " + temp);
                }
                else if (s.charAt(0) == 'U')
                {
                    StringTokenizer st = new StringTokenizer(s);
                    st.nextToken();
                    String temp = st.nextToken();
                    nc.write(client);
                    nc.write("U");
                    nc.write(temp);
                    nc.write(client.name + " unsubscribed stock " + temp);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}



