package PizzaShop;

import PizzaShop.PizzaDecorator.Apetizer.Apetizer;
import PizzaShop.PizzaDecorator.Apetizer.FrenchFri;
import PizzaShop.PizzaDecorator.Pizza.Pizza;
import PizzaShop.PizzaDecorator.PizzaDecorator;

public class BeefPizzaFrenchFry extends PizzaDecorator {
    private Apetizer apetizer;
    public BeefPizzaFrenchFry(Pizza pizza) {
        super(pizza);
        apetizer = new FrenchFri();
    }

    @Override
    public String preparePizza() {
        return super.preparePizza() + " with " +  apetizer.prepareApetizer();
    }
    @Override
    public double price() {
        return super.price() + apetizer.price();
    }
}
