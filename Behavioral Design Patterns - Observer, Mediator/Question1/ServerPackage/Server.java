package ServerPackage;

import ClientPackage.Client;
import javafx.util.Pair;
import util.NetworkUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;
    public int i = 1;
    public ArrayList<Pair<Client, NetworkUtil> > clientMap;
    public ArrayList<StockList> stockLists;

    Server() {
        stockLists = new ArrayList<>();
        clientMap = new ArrayList<>();

        try {
            File obj = new File("/media/mahbub/MAHBUB/MEGA/Level3Term1/CSE308/Offline4/StockMarket/src/ServerPackage/input");
            Scanner scanner = new Scanner(obj);
            while (scanner.hasNext()) {
                String name = scanner.next();
                int count = 0;
                float value = 0;
                if (scanner.hasNext()) {
                    count = Integer.parseInt((String) scanner.next());
                }
                if (scanner.hasNext()) {
                    value = Float.parseFloat((String) scanner.next());
                }
                stockLists.add(new StockList(name, count, value));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }


        try {
            serverSocket = new ServerSocket(33333);
            new WriteThreadServer(this, clientMap, "Server");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        Client client = (Client) nc.read();
        System.out.println("New user " + client.name + " is added");
        clientMap.add(new Pair<>(client, nc));
        new ReadThreadServer(this, clientMap, nc);
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
