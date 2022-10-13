package ServerPackage;

import javafx.util.Pair;
import util.NetworkUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import ClientPackage.Client;

public class WriteThreadServer implements Runnable {

    private Thread thr;
    String name;
    public ArrayList<Pair<Client, NetworkUtil> > clientMap;
    public HashSet<String> users = new HashSet<String>();
    Server server;

    public WriteThreadServer(Server server, ArrayList<Pair<Client, NetworkUtil> > map, String name) {
        this.server = server;
        this.clientMap = map;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                String s = input.nextLine();

                if (s.equalsIgnoreCase("notify")) {
                    notifyNewUsers();
                }
                else if (s.charAt(0)== 'I') {
                    StringTokenizer stringTokenizer = new StringTokenizer(s);
                    stringTokenizer.nextToken();
                    String stockName = stringTokenizer.nextToken();
                    float price = Float.parseFloat(stringTokenizer.nextToken());
                    increaseStockPrice(stockName, price);
                }
                else if (s.charAt(0)== 'D') {
                    StringTokenizer stringTokenizer = new StringTokenizer(s);
                    stringTokenizer.nextToken();
                    String stockName = stringTokenizer.nextToken();
                    float price = Float.parseFloat(stringTokenizer.nextToken());
                    decreaseStockPrice(stockName, price);
                }
                else if (s.charAt(0)== 'C') {
                    StringTokenizer stringTokenizer = new StringTokenizer(s);
                    stringTokenizer.nextToken();
                    String stockName = stringTokenizer.nextToken();
                    int count = Integer.parseInt(stringTokenizer.nextToken());
                    changeStockCount(stockName, count);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void notifyNewUsers() {
        for (int i = 0; i < clientMap.size();i++) {
            if (!users.contains(clientMap.get(i).getKey().name)) {

                for (int j = 0; j < server.stockLists.size(); j++) {
                    clientMap.get(i).getValue().write(server.stockLists.get(j));
                }
                users.add(clientMap.get(i).getKey().name);
            }

        }
    }


    public void increaseStockPrice(String stockName, float price)
    {
        StockList stockList = null;

        for (int i = 0; i < server.stockLists.size(); i++)
        {
            if (server.stockLists.get(i).name.equals(stockName))
            {
                stockList = new StockList(server.stockLists.get(i).name, server.stockLists.get(i).count, server.stockLists.get(i).price + price);
                server.stockLists.get(i).price += price;
                break;
            }
        }
        notifyStockChange(stockList);
    }

    public void decreaseStockPrice(String stockName, float price)
    {
        StockList stockList = null;
        for (int i = 0; i < server.stockLists.size(); i++)
        {
            if (server.stockLists.get(i).name.equals(stockName))
            {
                stockList = new StockList(server.stockLists.get(i).name, server.stockLists.get(i).count, server.stockLists.get(i).price - price);
                server.stockLists.get(i).price -= price;
                break;
            }
        }
        notifyStockChange(stockList);
    }

    public void changeStockCount(String stockName, int count)
    {
        StockList stockList = null;
        for (int i = 0; i < server.stockLists.size(); i++)
        {
            if (server.stockLists.get(i).name.equals(stockName))
            {
                stockList = new StockList(server.stockLists.get(i).name, count, server.stockLists.get(i).price);
                server.stockLists.get(i).count = count;
                break;
            }
        }
        notifyStockChange(stockList);
    }

    public void notifyStockChange(StockList stockList)
    {
        if (stockList == null) return;

        for (int i = 0; i < clientMap.size(); i++)
        {
            for (int j = 0; j < clientMap.get(i).getKey().subscribedStocks.size(); j++)
            {
                if (clientMap.get(i).getKey().subscribedStocks.get(j).equals(stockList.name))
                {
                    clientMap.get(i).getValue().write("Stock " + stockList.name + " has been changed");
                    clientMap.get(i).getValue().write(stockList);
                    break;
                }
            }
        }
    }
}



