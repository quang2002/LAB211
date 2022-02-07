/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package model;

import java.util.HashMap;
import utilities.IOHelper;

/**
 *
 * @author chall
 */
public class AccountManage {

    private HashMap<Integer, String> auth; // id, password
    private HashMap<Integer, Account> info; // id, account

    public AccountManage() {
        auth = new HashMap<>();
        info = new HashMap<>();
    }

    public void setAccount(Integer id, String password, String name, Float balance) {
        auth.put(id, password);
        info.put(id, new Account(id, name, balance));
    }

    public Account getAccount(Integer id) {
        return info.get(id);
    }

    public String getEncryptedPassword(Integer id) {
        return auth.get(id);
    }

    public void removeAccount(Integer id) {
        auth.remove(id);
        info.remove(id);
    }

    public boolean isAccountExist(Integer id) {
        return getAccount(id) != null;
    }

    public int getSize() {
        return auth.entrySet().size();
    }

    public void saveAuth() {
        try {
            IOHelper.saveObject("user.dat", auth);
        } catch (Exception e) {
            System.out.println("File not found: 'user.dat'");
        }
    }

    public void loadAuth() {
        try {
            auth = (HashMap<Integer, String>) IOHelper.loadObject("user.dat");
        } catch (Exception e) {
            System.out.println("File not found: 'user.dat'");
        }
    }

    public void saveInfo() {
        try {
            IOHelper.saveObject("bank.dat", info);
        } catch (Exception e) {
            System.out.println("File not found: 'bank.dat'");
        }
    }

    public void loadInfo() {
        try {
            info = (HashMap<Integer, Account>) IOHelper.loadObject("bank.dat");
        } catch (Exception e) {
            System.out.println("File not found: 'bank.dat'");
        }
    }
}
