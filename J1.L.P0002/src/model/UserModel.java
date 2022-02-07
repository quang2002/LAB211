/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package model;

/**
 *
 * @author chall
 */
public class UserModel {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;

    public UserModel() {
    }

    public UserModel(String username, String firstName, String lastName, String password, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s\n", username, password, firstName, lastName, phone, email);
    }
}
