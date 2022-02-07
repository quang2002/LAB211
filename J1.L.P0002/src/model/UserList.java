/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import utilities.StringHelper;

/**
 *
 * @author chall
 */
public class UserList extends ArrayList<UserModel> {

    public UserModel find(String username) {
        for (UserModel user : this) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean isExist(String username) {
        return find(username) != null;
    }

    public boolean saveMoreRecord(String filename, UserModel user) {
        try {
            try (FileWriter writer = new FileWriter(filename, true)) {
                writer.append(user.toString());
            }
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try {
            try (FileWriter writer = new FileWriter(filename)) {
                for (UserModel user : this) {
                    writer.append(user.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean loadFromFile(String filename) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                reader.lines().forEach((String line) -> {
                    String[] tokens = line.split("\\|");
                    if (tokens.length == 6) {
                        try {
                            UserValidation.checkValidUsername(tokens[0], this);
                            UserValidation.checkValidPhoneNumber(tokens[4]);
                            UserValidation.checkValidEmail(tokens[5]);

                            add(new UserModel(tokens[0], tokens[2], tokens[3], tokens[1], tokens[4], tokens[5]));
                        } catch (UserValidation e) {
                            System.out.println("Error: Invalid data at line: " + line + "\n" + e.getMessage());
                        }
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
            return false;
        }
        return true;
    }

    public void display() {
        if (isEmpty()) {
            return;
        }

        System.out.printf("%20s | %20s | %10s | %20s\n",
                StringHelper.center(20, "USERNAME"),
                StringHelper.center(20, "FULLNAME"),
                StringHelper.center(10, "PHONE"),
                StringHelper.center(20, "EMAIL")
        );
        for (UserModel user : this) {
            System.out.printf("%20s | %20s | %10s | %20s\n",
                    StringHelper.center(20, user.getUsername()),
                    StringHelper.center(20, user.getFirstName() + " " + user.getLastName()),
                    StringHelper.center(10, user.getPhone()),
                    StringHelper.center(20, user.getEmail())
            );
        }
    }
}
