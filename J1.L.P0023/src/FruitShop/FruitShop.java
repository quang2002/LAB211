/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package FruitShop;

import java.util.ArrayList;
import Components.*;
import Utilities.*;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author yuyu
 */
public class FruitShop {

    private final ArrayList<Fruit> fruits;
    private final Hashtable<String, ArrayList<Fruit>> orders;

    public FruitShop() {
        fruits = new ArrayList<>();
        orders = new Hashtable<>();
    }

    void createFruit() {
        String createMore = "Y";
        while (createMore.equalsIgnoreCase("Y")) {
            Fruit fruit = new Fruit();

            fruit.setId(fruits.size() + 1);

            fruit.setName(Validation.getString("Enter Fruit Name: ", ""));

            fruit.setPrice(Validation.getFloat("Enter Fruit Price: ", (value) -> (value >= 0.0f)));

            fruit.setQuantity(Validation.getInteger("Enter Fruit Quantity: ", (value) -> (value >= 0)));

            fruit.setOrigin(Validation.getString("Enter Fruit Origin: ", ""));

            fruits.add(fruit);

            createMore = Validation.getString("Do you want to continue (Y/N)? ", "[YyNn]{1}");
            System.out.println();
        }
    }

    void displayFruits() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit fruit : fruits) {
            System.out.printf(" %12s %18s %14s %13s \n",
                              StringHelper.center(12, fruit.getId()),
                              StringHelper.center(18, fruit.getName()),
                              StringHelper.center(14, fruit.getOrigin()),
                              StringHelper.center(13, fruit.getPrice() + "$")
            );
        }
        System.out.println();
    }

    void doShopping() {
        ArrayList<Fruit> orderedFruits = new ArrayList<>();

        String orderNow = "N";

        while (orderNow.equalsIgnoreCase("N")) {
            int fruitId = Validation.getInteger(
                    "Choose a fruit: ",
                    (value) -> {
                        if (0 < value && value <= fruits.size()) {
                            return true;
                        }
                        System.err.println("You must enter the fruit id from 'Item' column");
                        return false;
                    }
            );

            Fruit selectedFruit = fruits.get(fruitId - 1);
            System.out.println("You selected: " + selectedFruit.getName());

            int quantity = Validation.getInteger(
                    "Please input quantity: ",
                    (value) -> {
                        if (value < 0) {
                            System.err.println("You must input a non-negative integer");
                            return false;
                        }

                        if (value > selectedFruit.getQuantity()) {
                            System.err.printf("Error! Current %s quantity in storage is: %d",
                                              selectedFruit.getName(),
                                              selectedFruit.getQuantity()
                            );
                            return false;
                        }

                        return true;
                    }
            );

            if (quantity == 0) {
                continue;
            }

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

            Fruit cloneFruit = selectedFruit.createClone();
            cloneFruit.setQuantity(quantity);
            orderedFruits.add(cloneFruit);

            orderNow = Validation.getString("Do you want to order now (Y/N)? ", "[YyNn]{1}");
        }

        FruitShop.printListOfOrders(orderedFruits);

        String customerName = Validation.getString("Input your name: ", "[a-zA-Z ]+");
        orders.put(customerName, orderedFruits);

        System.out.println();
    }

    void displayOrders() {
        System.out.println();
        for (Map.Entry<String, ArrayList<Fruit>> order : orders.entrySet()) {
            System.out.println("Customer: " + order.getKey());
            FruitShop.printListOfOrders(order.getValue());
        }
    }

    private static void printListOfOrders(ArrayList<Fruit> fruits) {
        int total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (Fruit fruit : fruits) {
            int amount = (int) (fruit.getPrice() * fruit.getQuantity());
            total += amount;

            System.out.printf("%8s %10s %7s %7s\n",
                              StringHelper.center(8, fruit.getName()),
                              StringHelper.center(10, fruit.getQuantity()),
                              StringHelper.center(7, fruit.getPrice() + "$"),
                              StringHelper.center(7, amount + "$")
            );
        }

        System.out.println("Total: " + total + "$\n");
    }
}
