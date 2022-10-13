package PizzaShop.PizzaDecorator.Apetizer;

public class OnionRings implements Apetizer{
    @Override
    public double price() {
        return 100;
    }
    @Override
    public String prepareApetizer() {
        return "Onion Rings";
    }
}