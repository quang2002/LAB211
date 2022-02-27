/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package model;

import entity.Author;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yuyu
 * @param <T> entity type
 */
public abstract class ModelBase<T> implements Iterable<T> {

    protected ArrayList<T> data;
    protected Connection db;

    public ModelBase() {
        data = new ArrayList<>();
    }

    public ModelBase(Connection db) {
        this();
        this.db = db;
    }

    public Connection getDatabase() {
        return db;
    }

    public void setDatabase(Connection db) {
        this.db = db;
    }

    public int size() {
        return data.size();
    }

    public T get(int i) {
        int size = data.size();

        if (i < 0) {
            i += size;
        }

        if (i < 0 || i >= size) {
            return null;
        }

        return data.get(i);
    }

    public boolean remove(int i) {
        return remove(get(i));
    }

    public abstract boolean add(T obj);

    public abstract boolean remove(T obj);

    public abstract boolean update(T obj);

    public abstract boolean loadDB();

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
