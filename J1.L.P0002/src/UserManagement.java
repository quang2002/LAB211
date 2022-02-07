
import model.UserList;
import model.UserModel;
import model.UserValidation;
import utilities.Input;
import utilities.StringHelper;

/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
/**
 *
 * @author chall
 */
public class UserManagement {

    private final UserList users;

    public UserManagement() {
        users = new UserList();
    }

    public void createUserAccount() {
        do {
            UserModel user = new UserModel();

            // username
            user.setUsername(Input.getString("Enter username: ", (username) -> {
                try {
                    UserValidation.checkValidUsername(username, users);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            }));

            // password
            user.setPassword(StringHelper.SHA256(Input.getString("Enter password: ", (password) -> {
                try {
                    UserValidation.checkValidPassword(password);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            })));

            // re-password
            Input.getString("Re-Enter password: ", (password) -> {
                try {
                    UserValidation.checkValidPassword(password);

                    if (user.getPassword().equals(StringHelper.SHA256(password))) {
                        return true;
                    }

                    System.out.println("Error: Confirm password is not match!");
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                }
                return false;
            });

            // firstname & lastname
            user.setFirstName(Input.getString("Enter firstname: ", "[a-zA-Z ]+"));
            user.setLastName(Input.getString("Enter lastname: ", "[a-zA-Z ]+"));

            // phone
            user.setPhone(Input.getString("Enter phone number: ", (phone) -> {
                try {
                    UserValidation.checkValidPhoneNumber(phone);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            }));

            // email
            user.setEmail(Input.getString("Enter email address: ", (email) -> {
                try {
                    UserValidation.checkValidEmail(email);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            }));

            // create account
            System.out.println("Create account successful!");
            users.add(user);
            
            
        } while (Input.getBoolean("Do you want to continue? (Y/N) "));
    }

    public void checkExistUser() {
        do {
            String usr = Input.getString("Enter username: ", (username) -> {
                try {
                    UserValidation.checkValidUsername(username);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            });

            if (users.isExist(usr)) {
                System.out.println("Exist User");
            } else {
                System.out.println("No User Found!");
            }

        } while (Input.getBoolean("Do you want to continue? (Y/N) "));
    }

    public void searchUserInfo() {
        do {
            String search = Input.getString("Enter a part of firstname or lastname: ").trim().toLowerCase();

            UserList displayList = new UserList();

            for (UserModel user : users) {
                if ((user.getFirstName() + " " + user.getLastName()).toLowerCase().contains(search)) {
                    displayList.add(user);
                }
            }

            displayList.sort((UserModel usr1, UserModel usr2) -> usr1.getFirstName().compareToIgnoreCase(usr2.getFirstName()));

            if (displayList.isEmpty()) {
                System.out.println("Have no any user");
            } else {
                displayList.display();
            }

        } while (Input.getBoolean("Do you want to continue? (Y/N) "));
    }

    public void updateUser() {
        if (users.isEmpty()) {
            System.out.println("Please create more user!");
            return;
        }

        do {
            String usr = Input.getString("Enter username: ", (username) -> {
                try {
                    UserValidation.checkValidUsername(username);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }

                if (users.find(username) == null) {
                    System.out.println("Error: This user is not exist!");
                    return false;
                }

                return true;
            });

            String pwd = Input.getString("Enter password: ", (password) -> {
                try {
                    UserValidation.checkValidPassword(password);
                } catch (UserValidation e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            });

            UserModel loginAccount = users.find(usr);

            if (loginAccount.getPassword().equals(StringHelper.SHA256(pwd))) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
                return;
            }

            if (Input.getBoolean("Update or Delete? (U/D) ", "u|update", "d|delete")) {
                // update

                Input.getString("Enter new password: ", (password) -> {
                    try {
                        if (password.trim().isEmpty()) {
                            return true;
                        }

                        UserValidation.checkValidPassword(password);
                    } catch (UserValidation e) {
                        System.out.println(e.getMessage());
                        return false;
                    }

                    loginAccount.setPassword(StringHelper.SHA256(password));
                    return true;
                });

                Input.getString("Enter new firstname: ", (firstname) -> {
                    if (!firstname.trim().isEmpty()) {
                        loginAccount.setFirstName(firstname);
                    }
                    return true;
                });

                Input.getString("Enter new lastname: ", (lastname) -> {
                    if (!lastname.trim().isEmpty()) {
                        loginAccount.setFirstName(lastname);
                    }
                    return true;
                });

                Input.getString("Enter new phone number: ", (phone) -> {
                    try {
                        if (phone.trim().isEmpty()) {
                            return true;
                        }
                        UserValidation.checkValidPhoneNumber(phone);
                    } catch (UserValidation e) {
                        System.out.println(e.getMessage());
                        return false;
                    }
                    loginAccount.setPhone(phone);
                    return true;
                });

                Input.getString("Enter new email address: ", (email) -> {
                    try {
                        if (email.trim().isEmpty()) {
                            return true;
                        }
                        UserValidation.checkValidEmail(email);
                    } catch (UserValidation e) {
                        System.out.println(e.getMessage());
                        return false;
                    }
                    loginAccount.setEmail(email);
                    return true;
                });

                System.out.println("Update successful");

            } else {
                // delete
                users.remove(loginAccount);

                System.out.println("Delete successful");
            }
        } while (Input.getBoolean("Do you want to continue? (Y/N) "));
    }

    public void saveToFile() {
        users.saveToFile("user.txt");
        System.out.println("Save to file 'user.txt' successful");
        while (!Input.getBoolean("Back to mainmenu? (Y/N) "));
    }

    public void printAllListFromFile() {
        users.loadFromFile("user.txt");
        users.display();
        while (!Input.getBoolean("Back to mainmenu? (Y/N) "));
    }
}
