package PizzaShop.PizzaDecorator.Pizza;

public class BeefPizza implements Pizza {
    @Override
    public double price() {
        return 500;
    }
    @Override
    public String preparePizza() {
        return "Beef Pizza";
    }
}
