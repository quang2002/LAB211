/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.AuthorModel;
import model.BookModel;
import view.BookStoreMgrView;

/**
 *
 * @author yuyu
 */
public class BookStoreMgr {

    private Connection db;
    private BookModel bookModel;
    private AuthorModel authorModel;
    
    private BookStoreMgrView view;

    public BookStoreMgr() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            db = DriverManager.getConnection(
                    "jdbc:sqlserver://YUYU;databaseName=HKTBookStore",
                    "sa",
                    "271102"
            );

            authorModel = new AuthorModel(db);
            bookModel = new BookModel(authorModel, db);

            view = new BookStoreMgrView();
        } catch (SQLException e) {
            System.out.println("Connect to database failed!");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find class com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
    }

    public void closeConnection() {
        if (db != null) {
            try {
                db.close();
            } catch (SQLException e) {
                System.out.println("Close connection failed");
            }
        }
    }

    public void showTheBookList() {
        view.showTheBookList(bookModel);
    }

    public void addNewBook() {
        view.addNewBook(bookModel);
    }

    public void updateBook() {
        view.updateBook(bookModel);
    }

    public void deleteBook() {
        view.deleteBook(bookModel);
    }

    public void searchBookByTitle() {
        view.searchBookByTitle(bookModel);
    }

    public void searchBookByAuthorName() {
        view.searchBookByAuthorName(bookModel);
    }

    public void deleteAuthor() {
        view.deleteAuthor(authorModel);
    }
}
