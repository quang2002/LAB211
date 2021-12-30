package FruitShop;

import Utilities.Validation;

/**
 *
 * @author yuyu
 */
public class Main {

    private static int getChoice() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("\t1. Create Fruit");
        System.out.println("\t2. View orders");
        System.out.println("\t3. Shopping (for buyer)");
        System.out.println("\t4. Exit");

        return Validation.getInteger(
                "Your choice: ",
                (value) -> {
                    if (1 <= value && value <= 4) {
                        return true;
                    }
                    System.err.println("You must enter your an integer from 1 to 4 inclusive");
                    return false;
                }
        );
    }

    public static void main(String[] args) {
        FruitShop shop = new FruitShop();

        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    shop.createFruit();
                    shop.displayFruits();
                    break;
                case 2:
                    shop.displayOrders();
                    break;
                case 3:
                    shop.displayFruits();
                    shop.doShopping();
                    break;
                case 4:
                    return;
            }
        }
    }
}
