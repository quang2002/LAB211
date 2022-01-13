/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package model;

import java.io.Serializable;
import utilities.StringHelper;

/**
 *
 * @author chall
 */
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float balance;

    public Account(Integer id, String name, Float balance) {
        this.id = id;
        this.name = StringHelper.toTitle(name);
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringHelper.toTitle(name);
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

}
