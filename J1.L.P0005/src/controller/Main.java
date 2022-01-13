/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package controller;

import utilities.Input;

/**
 *
 * @author chall
 */
public class Main {

    public static int getChoice() {
        System.out.println("THE SECRET BANK");
        System.out.println("1. Create new account");
        System.out.println("2. Login");
        System.out.println("3. Withdraw");
        System.out.println("4. Deposit");
        System.out.println("5. Transfer");
        System.out.println("6. Remove");
        System.out.println("Others - Quits");

        return Input.getInteger("Your choice: ");
    }

    public static void main(String[] args) {
        SecretBank bank = new SecretBank();

        bank.loadDataFromDatabase();

        while (true) {
            int choice = getChoice();

            switch (choice) {
                case 1:
                    bank.create();
                    break;
                case 2:
                    bank.login();
                    break;
                case 3:
                    bank.withdraw();
                    break;
                case 4:
                    bank.deposit();
                    break;
                case 5:
                    bank.transfer();
                    break;
                case 6:
                    bank.remove();
                    break;
                default:
                    System.out.println("Goodbye...");
                    return;
            }
        }
    }
}
