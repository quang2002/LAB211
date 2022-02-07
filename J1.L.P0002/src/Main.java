
import utilities.Input;

/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
/**
 *
 * @author chall
 */
public class Main {

    public static int getChoice() {
        System.out.println("1. Create user account.");
        System.out.println("2. Check exists user.");
        System.out.println("3. Search user information by name.");
        System.out.println("4. Update user.");
        System.out.println("5. Save account to file.");
        System.out.println("6. Print list user form file.");
        System.out.println("Others - Quit");

        return Input.getInteger("Your choice: ");
    }

    public static void main(String[] args) {
        UserManagement management = new UserManagement();

        while (true) {
            int choice = getChoice();

            switch (choice) {
                case 1:
                    management.createUserAccount();
                    break;
                case 2:
                    management.checkExistUser();
                    break;
                case 3:
                    management.searchUserInfo();
                    break;
                case 4:
                    management.updateUser();
                    break;
                case 5:
                    management.saveToFile();
                    break;
                case 6:
                    management.printAllListFromFile();
                    break;
                default:
                    System.out.println("Goodbye...");
                    return;
            }
        }
    }
}
