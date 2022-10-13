package PizzaShop.PizzaDecorator.Drinks;

public class Coffee implements Drinks{
    @Override
    public double price() {
        return 60;
    }
    @Override
    public String prepareDrinks() {
        return "Coffee";
    }
}
