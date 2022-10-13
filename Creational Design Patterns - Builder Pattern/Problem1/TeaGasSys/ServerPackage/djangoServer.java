package TeaGasSys.ServerPackage;

import TeaGasSys.ServerPackage.Frameworks.Framework;
import TeaGasSys.ServerPackage.Frameworks.django;

public class djangoServer implements Server{
    @Override
    public Framework getFramework() {
        return new django();
    }
    @Override
    public void showServerInfo() {
        System.out.println("Server:");
        getFramework().getFramework();
    }
}
