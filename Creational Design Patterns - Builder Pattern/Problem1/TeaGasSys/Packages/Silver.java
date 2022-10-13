package TeaGasSys.Packages;

import TeaGasSys.Packages.Hardware.ControllerPackage.Button;
import TeaGasSys.Packages.Hardware.ControllerPackage.Controller;
import TeaGasSys.Packages.Hardware.ControllerPackage.TouchScreenController;
import TeaGasSys.Packages.Hardware.DisplayPackage.Display;
import TeaGasSys.Packages.Hardware.DisplayPackage.LCD;
import TeaGasSys.Packages.Hardware.DisplayPackage.TouchScreen;
import TeaGasSys.Packages.Hardware.IdentificationPackage.Identification;
import TeaGasSys.Packages.Hardware.IdentificationPackage.NFCcard;
import TeaGasSys.Packages.Hardware.IdentificationPackage.RFID;
import TeaGasSys.Packages.Hardware.MicroControllerPackage.AtMega32;
import TeaGasSys.Packages.Hardware.MicroControllerPackage.MicroController;
import TeaGasSys.Packages.Hardware.MicroControllerPackage.RaspberryPi;
import TeaGasSys.Packages.Hardware.StoragePackage.DefaultStorage;
import TeaGasSys.Packages.Hardware.StoragePackage.SDcard;
import TeaGasSys.Packages.Hardware.StoragePackage.Storage;
import TeaGasSys.Packages.Hardware.WeightMeasurement.LoadSensor;
import TeaGasSys.Packages.Hardware.WeightMeasurement.WeightMeasure;

public class Silver implements SystemPackage {

    @Override
    public MicroController getMicroController() {
        return new AtMega32();
    }
    @Override
    public Controller getController() {
        return new Button();
    }
    @Override
    public Display getDisplay() {
        return new LCD();
    }
    @Override
    public Identification getIdentification() {
        return new RFID();
    }
    @Override
    public Storage getStorage() {
        return new SDcard();
    }
    @Override
    public WeightMeasure getWeightMeasure() {
        return new LoadSensor();
    }

    @Override
    public void showPackage() {
        System.out.println("Silver Package: AtMega32 with load sensor");
    }
}