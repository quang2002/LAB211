/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package entity;

import model.AuthorModel;

/**
 *
 * @author yuyu
 */
public final class Author extends EntityBase {

    private final int id;
    private String name;

    public Author(int id, String name) {
        this.id = id;
        setName(name);
    }

    public Author(int id, String name, AuthorModel model) {
        this(id, name);
        inject(model);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name.trim();
        if (isInjected()) {
            return getModel().update(this);
        }
        return false;
    }
}
