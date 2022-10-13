package PizzaShop.PizzaDecorator.Drinks;

public class Coke implements Drinks{
    @Override
    public double price() {
        return 70;
    }
    @Override
    public String prepareDrinks() {
        return "Coke";
    }
}