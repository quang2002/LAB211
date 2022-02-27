/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package model;

import java.util.List;

/**
 *
 * @author chall
 */
public class UserValidation extends Exception {

    public UserValidation(String msg) {
        super(msg);
    }

    public static void checkValidUsername(String username, List<UserModel> list) throws UserValidation {
        if (!username.matches("[^\\s]{5,}")) {
            throw new UserValidation("Error: Username must be at least five characters and no spaces");
        }

        if (list != null) {
            for (UserModel user : list) {
                if (user.getUsername().equalsIgnoreCase(username)) {
                    throw new UserValidation("Error: Username is not allowed to duplicate in the database");
                }
            }
        }
    }

    public static void checkValidUsername(String username) throws UserValidation {
        checkValidUsername(username, null);
    }

    public static void checkValidPassword(String password) throws UserValidation {
        if (!password.matches("[^\\s]{6,}")) {
            throw new UserValidation("Error: Password must be at least six characters and no spaces");
        }
    }

    public static void checkValidPhoneNumber(String phone) throws UserValidation {
        if (!phone.matches("\\d{10}")) {
            throw new UserValidation("Error: Phone number must contain 10 numbers");
        }
    }

    public static void checkValidEmail(String email) throws UserValidation {
        if (!email.matches("^([\\w!#$%&'*+\\-/=?^_`{|}~]+\\.)*([\\w!#$%&'*+\\-/=?^_`{|}~]+)@[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)*$")) {
            throw new UserValidation("Error: Email must follow standard email format");
        }
    }
}
