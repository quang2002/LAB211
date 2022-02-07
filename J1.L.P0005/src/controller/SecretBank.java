/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package controller;

import model.Account;
import model.AccountManage;
import utilities.Input;
import utilities.StringHelper;

/**
 *
 * @author chall
 */
public class SecretBank {

    private final String REGEX_PASSWORD = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~])[^\\s]{6,}";
    private Account loginAccount;
    private AccountManage manage;

    public SecretBank() {
        manage = new AccountManage();
        loginAccount = null;
    }

    public void create() {
        int id = Input.getInteger("Enter account id: ", (value) -> {
            if (value <= 0) {
                System.out.println("Account id must be greater than zero!");
                return false;
            }

            if (manage.isAccountExist(value)) {
                System.out.println("This account already exist!");
                return false;
            }

            return true;
        });

        String name = Input.getString("Enter account name: ", "[a-zA-Z ]+");

        String password = Input.getString("Enter password: ", REGEX_PASSWORD);

        Input.getString("Enter password again: ", (value) -> {
            if (!password.equals(value)) {
                System.out.println("Not match with password, please enter again!");
                return false;
            }
            return true;
        });

        manage.setAccount(id, StringHelper.SHA256(password), name, 0.0f);
        System.out.println("Create account successful!");
        manage.saveAuth();
        manage.saveInfo();
    }

    public void login() {
        if (manage.getSize() < 1) {
            System.out.println("Please create more account!");
            return;
        }

        int id = Input.getInteger("Enter account id: ", (value) -> {
            if (value <= 0) {
                System.out.println("Account id must be greater than zero!");
                return false;
            }

            if (!manage.isAccountExist(value)) {
                System.out.println("This account is not exist!");
                return false;
            }

            return true;
        });

        String password = Input.getString("Enter password: ", REGEX_PASSWORD);

        if (StringHelper.SHA256(password).equals(manage.getEncryptedPassword(id))) {
            loginAccount = manage.getAccount(id);
            System.out.println("Account name: " + loginAccount.getName());
            System.out.println("Login successful!");
        } else {
            System.out.println("Wrong password!");
        }
    }

    public void withdraw() {
        if (loginAccount == null) {
            System.out.println("You must login first!");
            return;
        }

        float cast = Input.getFloatInclusive("Enter amount of money to withdraw: ", 0.0f, loginAccount.getBalance());

        if (cast > 0.0f) {
            loginAccount.setBalance(loginAccount.getBalance() - cast);
            manage.saveInfo();
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("Withdraw failed!");
        }
    }

    public void deposit() {
        if (loginAccount == null) {
            System.out.println("You must login first!");
            return;
        }

        float cast = Input.getFloatInclusive("Enter amount of money to deposit: ", 0.0f, Float.MAX_VALUE);

        if (cast > 0.0f && Input.getBoolean("Confirm? ", "yes", "no")) {
            loginAccount.setBalance(loginAccount.getBalance() + cast);
            manage.saveInfo();
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit failed!");
        }
    }

    public void transfer() {
        if (loginAccount == null) {
            System.out.println("You must login first!");
            return;
        }

        if (manage.getSize() < 2) {
            System.out.println("Please create more account!");
            return;
        }

        int receiverId = Input.getInteger("Enter receiver's account id: ", (value) -> {
            if (value <= 0) {
                System.out.println("Account id must be greater than zero!");
                return false;
            }

//            if (loginAccount.getId().equals(value)) {
//                System.out.println("You can't transfer to yourself!");
//                return false;
//            }

            if (!manage.isAccountExist(value)) {
                System.out.println("This account is not exist!");
                return false;
            }

            return true;
        });

        Account receiver = manage.getAccount(receiverId);

        System.out.println("Receiver: " + receiver.getName());

        float cast = Input.getFloatInclusive("Enter amount of money to tranfer: ", 0.0f, loginAccount.getBalance());

        if (cast > 0.0f && Input.getBoolean("Confirm? ", "yes", "no")) {
            loginAccount.setBalance(loginAccount.getBalance() - cast);
            receiver.setBalance(receiver.getBalance() + cast);
            manage.saveInfo();
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Transfer failed!");
        }
    }

    public void remove() {
        if (loginAccount == null) {
            System.out.println("You must login first!");
            return;
        }

        if (Input.getBoolean("Confirm? ", "yes", "no")) {
            manage.removeAccount(loginAccount.getId());
            manage.saveInfo();
            manage.saveAuth();

            loginAccount = null;
            System.out.println("Remove successful!");
        } else {
            System.out.println("Remove failed!");
        }
    }

    public void loadDataFromDatabase() {
        manage.loadAuth();
        manage.loadInfo();
    }
}
