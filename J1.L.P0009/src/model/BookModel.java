/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package model;

import entity.Book;
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
public final class BookModel extends ModelBase<Book> {

    private final AuthorModel authorModel;

    public BookModel(AuthorModel authorModel, Connection db) {
        super(db);
        this.authorModel = authorModel;

        if (!this.loadDB()) {
            System.out.println("[ ERROR ] BookModel.<init>");
        }
    }

    @Override
    public boolean add(Book book) {
        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            try (PreparedStatement stmt = db.prepareStatement("INSERT INTO Book VALUES (?, ?, ?, ?)")) {
                stmt.setNString(1, book.getIsbn());
                stmt.setNString(2, book.getTitle());
                stmt.setFloat(3, book.getPrice());
                stmt.setInt(4, book.getAuthor().getId());

                stmt.execute();
            }

            book.inject(this);
            data.add(book);
        } catch (SQLException e) {
            System.out.println("[ ERROR ] BookModel.add(" + book.getIsbn() + "): " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Book book) {
        if (book == null) {
            return false;
        }

        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            try (PreparedStatement stmt = db.prepareStatement("DELETE FROM Book WHERE BookISBN = ?")) {
                stmt.setString(1, book.getIsbn());

                stmt.execute();
            }

            data.remove(book);
        } catch (SQLException e) {
            System.out.println("[ ERROR ] BookModel.remove(" + book.getIsbn() + "): " + e.getMessage());
            return false;
        }
        return true;
    }

    public Book findByISBN(String isbn) {

        isbn = isbn.replace("-", "");

        for (Book author : this) {
            if (author.getIsbn().replace("-", "").equals(isbn)) {
                return author;
            }
        }
        return null;
    }

    public AuthorModel getAuthorModel() {
        return authorModel;
    }

    @Override
    public boolean update(Book book) {
        if (book == null) {
            return false;
        }

        try {
            if (db == null || db.isClosed() || data == null) {
                return false;
            }

            try (PreparedStatement stmt = db.prepareStatement("UPDATE Book SET BookTitle = ?, BookPrice = ?, AuthorID = ? WHERE BookISBN = ?")) {
                stmt.setNString(1, book.getTitle());
                stmt.setFloat(2, book.getPrice());
                stmt.setInt(3, book.getAuthor().getId());
                stmt.setString(4, book.getIsbn());

                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println("[ ERROR ] BookModel.updateBook(" + book.getIsbn() + "): " + e.getMessage());
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
                ResultSet result = stmt.executeQuery("SELECT * FROM Book");
                while (result.next()) {
                    String ISBN = result.getString("BookISBN");
                    String title = result.getNString("BookTitle");
                    float price = result.getFloat("BookPrice");
                    int authorID = result.getInt("AuthorID");

                    Author author = authorModel.findByID(authorID);
                    if (author != null) {
                        data.add(new Book(ISBN, title, price, author, this));
                    }
                }
            }
        } catch (SQLException e) {
            return false;
        }

        // successful
        return true;
    }
}
