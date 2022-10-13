package ServerPackage;

import ClientPackage.Client;
import javafx.util.Pair;
import util.NetworkUtil;

import java.util.ArrayList;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    ArrayList<Pair<Client, NetworkUtil> > clientMap;
    Server server;

    public ReadThreadServer(Server server, ArrayList<Pair<Client, NetworkUtil> > clientMap, NetworkUtil nc) {
        this.server = server;
        this.clientMap = clientMap;
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o != null) {
                    if (o instanceof Client) {
                        Client client = (Client) o;
                        String type =(String) nc.read();
                        String stockName = (String) nc.read();

                        for (int i = 0; i < clientMap.size(); i++)
                        {
                            if (clientMap.get(i).getKey().name.equals(client.name))
                            {
                                if (type.equals("S")) clientMap.get(i).getKey().subscribedStocks.add(stockName);
                                else clientMap.get(i).getKey().subscribedStocks.remove(stockName);
                                break;
                            }

                        }
                    }
                    else if (o instanceof String) {
                        System.out.println(o);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}



