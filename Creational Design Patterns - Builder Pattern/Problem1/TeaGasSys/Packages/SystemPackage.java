package TeaGasSys.Packages;


import TeaGasSys.Packages.Hardware.ControllerPackage.Controller;
import TeaGasSys.Packages.Hardware.DisplayPackage.Display;
import TeaGasSys.Packages.Hardware.IdentificationPackage.Identification;
import TeaGasSys.Packages.Hardware.MicroControllerPackage.MicroController;
import TeaGasSys.Packages.Hardware.StoragePackage.Storage;
import TeaGasSys.Packages.Hardware.WeightMeasurement.WeightMeasure;

public interface SystemPackage {
    public MicroController getMicroController();
    public Controller getController();
    public Display getDisplay();
    public Identification getIdentification();
    public Storage getStorage();
    public WeightMeasure getWeightMeasure();
    public void showPackage();
}