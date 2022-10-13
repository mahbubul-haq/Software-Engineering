package TeaGasSys.Packages.Hardware.WeightMeasurement;

public class WeightModule implements WeightMeasure{

    @Override
    public void measuringType() {
        System.out.println("Weight Module");
    }
    @Override
    public void measure() {
        System.out.println("Measuring weight with Weight Module");
    }
}