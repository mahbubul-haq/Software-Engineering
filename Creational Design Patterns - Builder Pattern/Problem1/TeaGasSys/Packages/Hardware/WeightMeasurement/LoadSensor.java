package TeaGasSys.Packages.Hardware.WeightMeasurement;

public class LoadSensor implements WeightMeasure{
    @Override
    public void measuringType() {
        System.out.println("Load Sensor");
    }
    @Override
    public void measure() {
        System.out.println("Measuring weight with Load Sensor");
    }
}