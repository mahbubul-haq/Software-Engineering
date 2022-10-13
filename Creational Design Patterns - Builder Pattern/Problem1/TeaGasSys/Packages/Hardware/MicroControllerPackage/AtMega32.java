package TeaGasSys.Packages.Hardware.MicroControllerPackage;

public class AtMega32 implements MicroController{

    @Override
    public void microControllerType() {
        System.out.println("Using AtMega32 microcontroller");
    }
}