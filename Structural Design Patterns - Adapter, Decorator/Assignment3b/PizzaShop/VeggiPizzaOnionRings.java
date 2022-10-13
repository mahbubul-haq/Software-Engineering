package PizzaShop;

import PizzaShop.PizzaDecorator.Apetizer.Apetizer;
import PizzaShop.PizzaDecorator.Apetizer.FrenchFri;
import PizzaShop.PizzaDecorator.Apetizer.OnionRings;
import PizzaShop.PizzaDecorator.Pizza.Pizza;
import PizzaShop.PizzaDecorator.PizzaDecorator;

public class VeggiPizzaOnionRings extends PizzaDecorator {
    private Apetizer apetizer;
    public VeggiPizzaOnionRings(Pizza pizza) {
        super(pizza);
        apetizer = new OnionRings();
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
