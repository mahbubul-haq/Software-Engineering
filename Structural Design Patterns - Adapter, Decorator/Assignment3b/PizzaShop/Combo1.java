package PizzaShop;

import PizzaShop.PizzaDecorator.Apetizer.Apetizer;
import PizzaShop.PizzaDecorator.Apetizer.FrenchFri;
import PizzaShop.PizzaDecorator.Drinks.Coke;
import PizzaShop.PizzaDecorator.Drinks.Drinks;
import PizzaShop.PizzaDecorator.Pizza.Pizza;
import PizzaShop.PizzaDecorator.PizzaDecorator;

public class Combo1 extends PizzaDecorator {
    private Apetizer apetizer;
    private Drinks drinks;

    public Combo1(Pizza pizza) {
        super(pizza);
        apetizer = new FrenchFri();
        drinks = new Coke();
    }

    @Override
    public String preparePizza() {
        return super.preparePizza() + " with " +  apetizer.prepareApetizer() + " and " + drinks.prepareDrinks();
    }
    @Override
    public double price() {
        return super.price() + apetizer.price() + drinks.price();
    }
}
