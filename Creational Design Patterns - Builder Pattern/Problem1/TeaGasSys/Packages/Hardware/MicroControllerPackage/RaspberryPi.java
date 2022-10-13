package TeaGasSys.Packages.Hardware.MicroControllerPackage;
public class RaspberryPi implements MicroController{
    @Override
    public void microControllerType() {
        System.out.println("Using RaspberryPi Microcontroller");
    }
}