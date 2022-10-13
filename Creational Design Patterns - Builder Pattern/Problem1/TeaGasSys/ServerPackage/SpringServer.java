package TeaGasSys.ServerPackage;

import TeaGasSys.ServerPackage.Frameworks.Framework;
import TeaGasSys.ServerPackage.Frameworks.Spring;

public class SpringServer implements Server{
    @Override
    public Framework getFramework() {
        return new Spring();
    }

    @Override
    public void showServerInfo() {
        System.out.println("Server:");
        getFramework().getFramework();
    }
}
