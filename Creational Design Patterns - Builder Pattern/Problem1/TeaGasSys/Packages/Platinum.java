package TeaGasSys.Packages;


import TeaGasSys.Packages.Hardware.ControllerPackage.Controller;
import TeaGasSys.Packages.Hardware.ControllerPackage.TouchScreenController;
import TeaGasSys.Packages.Hardware.DisplayPackage.Display;
import TeaGasSys.Packages.Hardware.DisplayPackage.TouchScreen;
import TeaGasSys.Packages.Hardware.IdentificationPackage.Identification;
import TeaGasSys.Packages.Hardware.IdentificationPackage.NFCcard;
import TeaGasSys.Packages.Hardware.MicroControllerPackage.MicroController;
import TeaGasSys.Packages.Hardware.MicroControllerPackage.RaspberryPi;
import TeaGasSys.Packages.Hardware.StoragePackage.DefaultStorage;
import TeaGasSys.Packages.Hardware.StoragePackage.Storage;
import TeaGasSys.Packages.Hardware.WeightMeasurement.LoadSensor;
import TeaGasSys.Packages.Hardware.WeightMeasurement.WeightMeasure;
import TeaGasSys.Packages.Hardware.WeightMeasurement.WeightModule;

public class Platinum implements SystemPackage {

    @Override
    public MicroController getMicroController() {
        return new RaspberryPi();
    }
    @Override
    public Controller getController() {
        return new TouchScreenController();
    }
    @Override
    public Display getDisplay() {
        return new TouchScreen();
    }
    @Override
    public Identification getIdentification() {
        return new NFCcard();
    }
    @Override
    public Storage getStorage() {
        return new DefaultStorage();
    }
    @Override
    public WeightMeasure getWeightMeasure() {
        return new WeightModule();
    }
    @Override
    public void showPackage() {
        System.out.println("Platinum Package: Raspberrypi with weight module");
    }
}