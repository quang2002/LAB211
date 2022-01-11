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
        System.out.println("\t2. Update Fruit");
        System.out.println("\t3. View orders");
        System.out.println("\t4. Shopping (for buyer)");
        System.out.println("\t5. Exit");

        return Validation.getIntegerInclusive("Your choice: ", 1, 5);
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
                    shop.updateFruit();
                    shop.displayFruits();
                    break;
                case 3:
                    shop.displayOrders();
                    break;
                case 4:
                    shop.doShopping();
                    break;
                case 5:
                    System.out.println("Bye...");
                    return;
            }
        }
    }
}
