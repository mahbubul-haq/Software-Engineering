package TeaGasSys.Packages.Hardware.StoragePackage;

public class SDcard implements Storage{
    @Override
    public void storageType() {

        System.out.println("Storage in SD card");
    }

}