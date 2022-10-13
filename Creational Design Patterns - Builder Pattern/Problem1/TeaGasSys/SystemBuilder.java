package TeaGasSys;
import TeaGasSys.InternetConnection.GSM;
import TeaGasSys.InternetConnection.Ethernet;
import TeaGasSys.InternetConnection.Wifi;
import TeaGasSys.Packages.Diamond;
import TeaGasSys.Packages.Gold;
import TeaGasSys.Packages.Platinum;
import TeaGasSys.Packages.Silver;
import TeaGasSys.ServerPackage.LaravelServer;
import TeaGasSys.ServerPackage.SpringServer;
import TeaGasSys.ServerPackage.djangoServer;

import java.util.Scanner;

public class SystemBuilder {

    public NewSystem getNewSystem() {
        NewSystem newSystem = new NewSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number to choose a package");
        System.out.print("1. Silver\n2. Gold\n3. Diamond\n4. Platinum\n5. Exit\n");

        int choice = scanner.nextInt();
        int internetChoice;
        int serverChoice;

        switch (choice) {
            case 1:
                newSystem.setMyPackage(new Silver());
                System.out.println("Please enter a number to choose Internet connection");
                System.out.println("1. Wifi\n2. GSM");
                internetChoice = scanner.nextInt();

                if (internetChoice == 1) {
                    newSystem.setInternet(new Wifi());
                }
                else if (internetChoice == 2) {
                    newSystem.setInternet(new GSM());
                }
                else {
                    System.out.println("System creation failed");
                    return null;
                }
                break;
            case 2:
                newSystem.setMyPackage(new Gold());
                System.out.println("Please enter a number to choose Internet connection");
                System.out.println("1. Wifi\n2. GSM");
                internetChoice = scanner.nextInt();

                if (internetChoice == 1) {
                    newSystem.setInternet(new Wifi());
                }
                else if (internetChoice == 2) {
                    newSystem.setInternet(new GSM());
                }
                else {
                    System.out.println("System creation failed");
                    return null;
                }
                break;
            case 3:
                newSystem.setMyPackage(new Diamond());
                System.out.println("Please enter a number to choose Internet connection");
                System.out.println("1. Wifi\n2.GSM\n3. Ethernet");
                internetChoice = scanner.nextInt();

                if (internetChoice == 1) {
                    newSystem.setInternet(new Wifi());
                }
                else if (internetChoice == 2) {
                    newSystem.setInternet(new GSM());
                }
                else if (internetChoice == 3) {
                    newSystem.setInternet(new Ethernet());
                }
                else {
                    System.out.println("System creation failed");
                    return null;
                }
                break;
            case 4:
                newSystem.setMyPackage(new Platinum());
                System.out.println("Please enter a number to choose Internet connection");
                System.out.println("1. Wifi\n2. GSM\n3. Ethernet");
                internetChoice = scanner.nextInt();

                if (internetChoice == 1) {
                    newSystem.setInternet(new Wifi());
                }
                else if (internetChoice == 2) {
                    newSystem.setInternet(new GSM());
                }
                else if (internetChoice == 3) {
                    newSystem.setInternet(new Ethernet());
                }
                else {
                    System.out.println("System creation failed");
                    return null;
                }
                break;
            default:
                System.out.println("System creation failed");
                return null;
        }

        System.out.println("Please enter a number to choose server");
        System.out.println("1. Django\n2. Spring\n3. Laravel");

        serverChoice = scanner.nextInt();

        if (serverChoice == 1) {
            newSystem.setServer(new djangoServer());
        }
        else if (serverChoice == 2) {
            newSystem.setServer(new SpringServer());
        }
        else if (serverChoice == 3) {
            newSystem.setServer(new LaravelServer());
        }
        else {
            System.out.println("System creation failed");
            return null;
        }

        System.out.println("System created successfully");

        return newSystem;


    }

}
