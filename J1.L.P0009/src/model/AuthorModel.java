/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package model;

import entity.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yuyu
 */
public class AuthorModel extends ModelBase<Author> {

    public AuthorModel(Connection db) {
        super(db);
        
        if (!this.loadDB()) {
            System.out.println("[ ERROR ] AuthorModel.<init>");
        }
    }

    public boolean add(String authorName) {
        return add(new Author(0, authorName));
    }

    @Override
    public boolean add(Author author) {
        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            try (PreparedStatement stmt = db.prepareStatement("INSERT INTO Author(AuthorName) VALUES (?)")) {
                stmt.setNString(1, author.getName());

                stmt.execute();
            }

            int lastID = data.get(data.size() - 1).getId();
            data.add(new Author(lastID + 1, author.getName(), this));
        } catch (SQLException e) {
            System.out.println("[ ERROR ] AuthorModel.add(" + author.getName() + "): " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Author author) {
        if (author == null) {
            return false;
        }

        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            try (PreparedStatement stmt = db.prepareStatement("DELETE FROM Author WHERE AuthorID = ?")) {
                stmt.setInt(1, author.getId());

                stmt.execute();
            }

            data.remove(author);
        } catch (SQLException e) {
            System.out.println("[ ERROR ] AuthorModel.remove(" + author.getId() + "): " + e.getMessage());
            return false;
        }
        return true;
    }

    public Author findByID(int id) {
        for (Author author : this) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean update(Author author) {
        if (author == null) {
            return false;
        }

        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            try (PreparedStatement stmt = db.prepareStatement("UPDATE Author SET AuthorName = ? WHERE AuthorID = ?")) {
                stmt.setNString(1, author.getName());
                stmt.setInt(2, author.getId());

                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println("[ ERROR ] AuthorModel.update(" + author.getId() + "): " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public final boolean loadDB() {
        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            // clear list before load data from database
            data.clear();

            // start
            try (Statement stmt = db.createStatement()) {
                ResultSet result = stmt.executeQuery("SELECT * FROM Author");
                while (result.next()) {
                    int id = result.getInt("AuthorID");
                    String name = result.getNString("AuthorName");
                    data.add(new Author(id, name, this));
                }
            }
        } catch (SQLException e) {
            return false;
        }

        // successful
        return true;
    }
}
