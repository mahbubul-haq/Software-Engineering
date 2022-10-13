package TeaGasSys.ServerPackage;

import TeaGasSys.ServerPackage.Frameworks.Framework;
import TeaGasSys.ServerPackage.Frameworks.Laravel;

public class LaravelServer implements Server{
    @Override
    public Framework getFramework() {
        return new Laravel();
    }

    @Override
    public void showServerInfo() {
        System.out.println("Server:");
        getFramework().getFramework();
    }
}
