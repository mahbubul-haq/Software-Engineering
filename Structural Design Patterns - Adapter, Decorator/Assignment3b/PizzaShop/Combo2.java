package PizzaShop;

import PizzaShop.PizzaDecorator.Apetizer.Apetizer;
import PizzaShop.PizzaDecorator.Apetizer.FrenchFri;
import PizzaShop.PizzaDecorator.Drinks.Coffee;
import PizzaShop.PizzaDecorator.Drinks.Coke;
import PizzaShop.PizzaDecorator.Drinks.Drinks;
import PizzaShop.PizzaDecorator.Pizza.Pizza;
import PizzaShop.PizzaDecorator.PizzaDecorator;

public class Combo2 extends PizzaDecorator {
    private Drinks drinks;

    public Combo2(Pizza pizza) {
        super(new VeggiPizzaOnionRings(pizza));
        drinks = new Coffee();
    }

    @Override
    public String preparePizza() {
        return super.preparePizza() + " and " + drinks.prepareDrinks();
    }
    @Override
    public double price() {
        return super.price() + drinks.price();
    }
}
