package ClientPackage;

import util.NetworkUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Serializable {
    public String name;
    public ArrayList<String> subscribedStocks;

    public Client(String serverAddress, int serverPort) {
        subscribedStocks = new ArrayList<>();
        try {
            System.out.print("Please enter your name: ");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
            networkUtil.write(this);

            new ReadThreadClient(networkUtil);
            new WriteThreadClient(this, networkUtil);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        Client client = new Client(serverAddress, serverPort);
    }
}

