import PizzaShop.BeefPizzaFrenchFry;
import PizzaShop.Combo1;
import PizzaShop.Combo2;
import PizzaShop.PizzaDecorator.Pizza.BeefPizza;
import PizzaShop.PizzaDecorator.Pizza.Pizza;
import PizzaShop.PizzaDecorator.Pizza.VeggiPizza;
import PizzaShop.VeggiPizzaOnionRings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;
        boolean flag = true;

        while (true) {

            System.out.println("1. Beef Pizza with French fry, 2. Veggi Pizza with onions rings");
            System.out.println("3. combo1(veggi pizza, french fry and coke), 4. combo2(veggi pizza, onion rings and coffee)");
            System.out.println("5. Beef Pizza only, 0. quit. Please enter your choice");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pizza = new BeefPizzaFrenchFry(new BeefPizza());
                    break;
                case 2:
                    pizza = new VeggiPizzaOnionRings(new VeggiPizza());
                    break;
                case 3:
                    pizza = new Combo1(new VeggiPizza());
                    break;
                case 4:
                    pizza = new Combo2(new VeggiPizza());
                    break;
                case 5:
                    pizza = new BeefPizza();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            if (!flag) break;

            if (pizza != null) {
                System.out.println(pizza.preparePizza());
                System.out.println("Cost: " + pizza.price());
            }
            pizza = null;
        }

    }
}

