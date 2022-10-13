package TeaGasSys;

import TeaGasSys.InternetConnection.Internet;
import TeaGasSys.Packages.SystemPackage;
import TeaGasSys.ServerPackage.Server;

public class NewSystem {
    private Server server = null;
    private Internet internet = null;
    public SystemPackage mySystemPackage = null;

    public void setServer(Server server) {
        this.server = server;
    }
    public void setInternet(Internet internet) {
        this.internet = internet;
    }
    public void setMyPackage(SystemPackage mySystemPackage) {

        this.mySystemPackage = mySystemPackage;
    }

    public Server getServer() {
        return server;
    }
    public Internet getInternet() {
        return internet;
    }
    public SystemPackage getSystemPackage() {
        return mySystemPackage;
    }

    public void showController() {
        if (mySystemPackage == null) {
            System.out.println("No controller found");
            return;
        }
        mySystemPackage.getController().controllerType();
    }
    public void showFramework() {
        if (server == null) {
            System.out.println("No framework found");
            return;
        }
        server.getFramework().getFramework();
    }

    public void showInternet() {
        if (internet == null) {
            System.out.println("No internet found");
            return;
        }
        internet.connect();
    }

    public void measureWeight() {
        if (mySystemPackage != null) {
            mySystemPackage.getWeightMeasure().measure();
        }
        else {
            System.out.println("No measuring device");
        }
    }

    public void showDisplay() {
        if (mySystemPackage != null) {
            mySystemPackage.getDisplay().displayMethod();
        }else {
            System.out.println("NO display device found");
        }
    }

    public void showIdentification() {
        if (mySystemPackage != null) {
            mySystemPackage.getIdentification().identificationType();
        }
        else System.out.println("No identificaiton");
    }

    public void showStorage() {
        if (mySystemPackage != null) {
            mySystemPackage.getStorage().storageType();
        }
        else System.out.println("No storage");
    }

    public void showMicroControllerType() {
        if (mySystemPackage != null) {
            mySystemPackage.getMicroController().microControllerType();
        }
        else System.out.println("No microcontroller");
    }

    public void showServerInfo() {
        if (server != null) {
            server.showServerInfo();
        }
        else System.out.println("No server");
    }

    public void showPackage() {
        if (mySystemPackage != null) {
            mySystemPackage.showPackage();
        }
    }

    public void showSystem() {
        if (server != null) {
            showServerInfo();
        }
        if (internet != null) {
            showInternet();
        }
        if (mySystemPackage != null) {
            showPackage();
        }
    }

}
