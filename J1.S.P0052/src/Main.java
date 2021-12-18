
/**
 *
 * @author yuyu
 */
public class Main {

    public static int getMenuChoice() {
        System.out.println();
        System.out.println("                                        MENU                                         ");
        System.out.println("=====================================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("=====================================================================================");

        Validation vld = new Validation();
        return vld.getInteger("Enter your choice: ", 1, 5);
    }

    public static void main(String[] args) {
        ManageEastAsiaCountries mgr = new ManageEastAsiaCountries();
        int choice;
        do {
            choice = getMenuChoice();
            switch (choice) {
                case 1:
                    mgr.addCountry();
                    break;
                case 2:
                    mgr.displayLastCountry();
                    break;
                case 3:
                    mgr.searchCountry();
                    break;
                case 4:
                    mgr.displayAllCountries();
                    break;
            }
        }
        while (choice != 5);
    }
}
