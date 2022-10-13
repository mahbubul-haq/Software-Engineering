package ClientPackage;

import ServerPackage.StockList;
import util.NetworkUtil;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil nc;

    public ReadThreadClient(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o != null) {
                    if (o instanceof StockList) {
                        StockList stockList = (StockList) o;
                        System.out.println(stockList.name + " " + stockList.count + " " + stockList.price);
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



