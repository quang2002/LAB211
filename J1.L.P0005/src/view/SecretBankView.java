/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package view;

import utilities.Input;

/**
 *
 * @author chall
 */
public class SecretBankView {

    /**
     * Get user's choice from 1 to 6 otherwise, exit program
     *
     * @return
     */
    public int getMenuChoice() {
        System.out.println("1. Create new account");
        System.out.println("2. Login");
        System.out.println("3. Withdrawal");
        System.out.println("4. Deposit");
        System.out.println("5. Transfer money");
        System.out.println("6. Remove account");

        return Input.getInteger("Your choice (Others - Quit): ");
    }
}
