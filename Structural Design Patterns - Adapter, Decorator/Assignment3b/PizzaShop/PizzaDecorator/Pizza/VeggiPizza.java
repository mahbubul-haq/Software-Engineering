package PizzaShop.PizzaDecorator.Pizza;

public class VeggiPizza implements Pizza{
    @Override
    public double price() {
        return 400;
    }
    @Override
    public String preparePizza() {
        return "Veggi Pizza";
    }
}
