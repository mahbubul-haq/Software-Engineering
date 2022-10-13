package PizzaShop.PizzaDecorator.Apetizer;

public class FrenchFri implements Apetizer{
    @Override
    public double price() {
        return 100;
    }
    @Override
    public String prepareApetizer() {
        return "French Fries";
    }
}
