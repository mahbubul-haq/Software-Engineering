package TeaGasSys.ServerPackage;

import TeaGasSys.ServerPackage.Frameworks.Framework;

public interface Server {
    public abstract Framework getFramework();
    public abstract void showServerInfo();
}