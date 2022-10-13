package TeaGasSys.Packages.Hardware.MicroControllerPackage;

public class ArduinoMega implements MicroController{

    @Override
    public void microControllerType() {
        System.out.println("Using ArduinoMega microcontroller");
    }
}