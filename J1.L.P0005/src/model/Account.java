/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author chall
 */
public class Account implements Serializable {

    private final int id;
    private String name;
    private String password;

    public Account(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            return this.id == ((Account) obj).id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }
}
