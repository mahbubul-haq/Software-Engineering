package PizzaShop.PizzaDecorator;

import PizzaShop.PizzaDecorator.Pizza.Pizza;

public abstract class PizzaDecorator implements Pizza {
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String preparePizza() {
        return pizza.preparePizza();
    }

    @Override
    public double price() {
        return pizza.price();
    }
}
