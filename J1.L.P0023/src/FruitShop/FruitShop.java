/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package FruitShop;

import Components.*;
import Utilities.*;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author yuyu
 */
public class FruitShop {

    private final FruitList fruitList;
    private final Hashtable<String, FruitList> orders;

    public FruitShop() {
        fruitList = new FruitList();
        orders = new Hashtable<>();
    }

    /**
     * Create Fruit (Fruit Id must be enter). After each Fruit is created, the
     * system shows message: Do you want to continue (Y/N)? User chooses Y to
     * continues, if you chooses N, break out from while loop
     */
    void createFruit() {
        do {
            Fruit fruit = new Fruit();

            // ID must be unique and positive
            fruit.setId(Validation.getInteger(
                    "Enter Fruit ID: ",
                    (id) -> {
                        if (id <= 0) {
                            System.err.println("Fruit id must be a positive number");
                            return false;
                        }

                        if (fruitList.exist(id)) {
                            System.err.println("This id already exist!");
                            return false;
                        }
                        return true;
                    })
            );

            // Name must be not empty and include [a-zA-Z0-9 ]
            fruit.setName(Validation.getString("Enter Fruit Name: ", "[\\w ]+"));

            // Price must be greater or equal to 0
            fruit.setPrice(Validation.getFloatInclusive("Enter Fruit Price: ", 0.0f, Float.MAX_VALUE));

            // Quantity must be greater or equal to 0
            fruit.setQuantity(Validation.getIntegerInclusive("Enter Fruit Quantity: ", 0, Integer.MAX_VALUE));

            // Origin must be not empty and include [a-zA-Z0-9 ]
            fruit.setOrigin(Validation.getString("Enter Fruit Origin: ", "[\\w ]+"));

            fruitList.add(fruit);

            System.out.println();
        } while (Validation.getBoolean("Do you want to continue (Y/N)? ", "y", "n"));
    }

    void createFruit(int id) {
        do {
            Fruit fruit = new Fruit();

            // ID must be unique and positive
            fruit.setId(id);

            // Name must be not empty and include [a-zA-Z0-9 ]
            fruit.setName(Validation.getString("Enter Fruit Name: ", "[\\w ]+"));

            // Price must be greater or equal to 0
            fruit.setPrice(Validation.getFloatInclusive("Enter Fruit Price: ", 0.0f, Float.MAX_VALUE));

            // Quantity must be greater or equal to 0
            fruit.setQuantity(Validation.getIntegerInclusive("Enter Fruit Quantity: ", 0, Integer.MAX_VALUE));

            // Origin must be not empty and include [a-zA-Z0-9 ]
            fruit.setOrigin(Validation.getString("Enter Fruit Origin: ", "[\\w ]+"));

            fruitList.add(fruit);

            System.out.println();
        } while (Validation.getBoolean("Do you want to continue (Y/N)? ", "y", "n"));
    }

    /**
     * Enter Fruit ID, update Quantity if it exists, otherwise ask for create
     * product (Yes/No: User choices ‘Yes’ to go to option 1, ‘No’ do nothing
     */
    void updateFruit() {
        if (fruitList.isEmpty()) {
            System.err.println("Not have any fruit in storage");
            return;
        }

        int id = Validation.getInteger("Enter fruit ID: ");
        Fruit fruit = fruitList.find(id);

        // if can't find that fruit then ask user for create, otherwise set new quantity
        if (fruit == null) {
            System.err.println("This id is not exist");
            if (Validation.getBoolean("Do you want to create fruit (Yes/No)? ", "yes", "no")) {
                createFruit(id);
            }
        } else {
            fruit.setQuantity(Validation.getIntegerInclusive("Enter new quantity: ", 0, Integer.MAX_VALUE));
        }
    }

    /**
     * Display all fruits with pretty format
     */
    void displayFruits() {
        // remove all fruits that has quantity <= 0
        fruitList.clean();

        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        fruitList.forEach((fruit) -> {
            System.out.printf(" %12s %18s %14s %13s \n",
                    StringHelper.center(12, fruit.getId()),
                    StringHelper.center(18, fruit.getName()),
                    StringHelper.center(14, fruit.getOrigin()),
                    StringHelper.center(13, fruit.getPrice() + "$")
            );
        });
        System.out.println();
    }

    /**
     * Display all fruits with pretty format
     */
    int getFruitsWithIndex() {
        // remove all fruits that has quantity <= 0
        fruitList.clean();

        System.out.println("| ++ ID ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        int count = 1;
        for (Fruit fruit : fruitList) {
            System.out.printf(" %10s %18s %14s %13s \n",
                    StringHelper.center(12, count),
                    StringHelper.center(18, fruit.getName()),
                    StringHelper.center(14, fruit.getOrigin()),
                    StringHelper.center(13, fruit.getPrice() + "$")
            );

            count++;
        }
        System.out.println();

        return Validation.getIntegerInclusive("Choose a fruit: ", 1, count);
    }

    /**
     * After customer inputs id and quantity of fruit, the program shows
     * message: Do you want to order now (Y/N). If customer selects N, the
     * program returns to List of Fruit to continue ordering. If select Y, the
     * program displays by Quantity descending order.
     *
     * Last, Customer inputs his/her name to finish ordering.
     */
    void doShopping() {
        if (fruitList.isEmpty()) {
            System.err.println("Not have any fruit in storage");
            return;
        }

        FruitList orderedFruits = new FruitList();

        do {
            Fruit fruit = null;
            // try to get fruit from user until get a valid fruits
            while (fruit == null) {
                fruit = fruitList.get(getFruitsWithIndex() - 1);
            }

            // get quantiy and name and set it final for use in lambda
            final int fruitQuantity = fruit.getQuantity();
            final String fruitName = fruit.getName();

            System.out.println("You selected: " + fruitName);

            int quantity = Validation.getInteger(
                    "Please input quantity: ",
                    (value) -> {
                        if (value < 0) {
                            System.err.println("You must input a non-negative integer");
                            return false;
                        }

                        if (value > fruitQuantity) {
                            String msg = String.format(
                                    "Error! Current %s quantity in storage is: %d",
                                    fruitName,
                                    fruitQuantity
                            );

                            System.err.println(msg);
                            return false;
                        }

                        return true;
                    }
            );

            // if bought quantity is equal to 0 then don't add it to ordered fruits list
            if (quantity == 0) {
                continue;
            }

            // set quantity of fruit in storage = current - quantity
            fruit.setQuantity(fruitQuantity - quantity);

            // quantity
            Fruit temp = fruit.clone();
            temp.setQuantity(quantity);
            orderedFruits.add(temp);
        } while (!Validation.getBoolean("Do you want to order now (Y/N)? ", "y", "n"));

        // sort ordered list by descending order
        orderedFruits.sort((Fruit f1, Fruit f2) -> f2.getQuantity() - f1.getQuantity());

        // print ordered list after shopping
        FruitShop.printListOfOrders(orderedFruits);

        String customerName = Validation.getString("Input your name: ", "[a-zA-Z ]+");

        while (orders.containsKey(customerName)) {
            customerName += "_";
        }
        orders.put(customerName, orderedFruits);

        System.out.println();
    }

    /**
     * Display all orders, who buy and how many product, total of cost
     */
    void displayOrders() {
        for (Map.Entry<String, FruitList> order : orders.entrySet()) {
            System.out.println("Customer: " + order.getKey().replace("_", ""));
            FruitShop.printListOfOrders(order.getValue());
        }
        System.out.println();
    }

    /**
     * Print out an order with pretty format
     *
     * @param fruits list of ordered fruits that you want to print out
     */
    private static void printListOfOrders(FruitList fruits) {
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
