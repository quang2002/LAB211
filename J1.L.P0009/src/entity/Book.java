/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package entity;

import model.BookModel;

/**
 *
 * @author yuyu
 */
public final class Book extends EntityBase {

    private final String isbn;
    private String title;
    private float price;
    private Author author;

    public Book(String isbn, String title, float price, Author author) {
        if (isValidISBN13(isbn)) {
            this.isbn = isbn.trim();
        } else {
            this.isbn = null;
            // throw new Exception("ISBN is null");
        }
        setTitle(title);
        setPrice(price);
        setAuthor(author);
    }

    public Book(String isbn, String title, float price, Author author, BookModel model) {
        this(isbn, title, price, author);
        inject(model);
    }

    public boolean setPrice(float price) {
        if (price >= 0) {
            this.price = price;
            if (isInjected()) {
                return getModel().update(this);
            }
        }
        return false;
    }

    public boolean setTitle(String title) {
        this.title = title.trim();
        if (isInjected()) {
            return getModel().update(this);
        }
        return false;
    }

    public boolean setAuthor(Author author) {
        if (author != null) {
            this.author = author;
            if (isInjected()) {
                return getModel().update(this);
            }
        }
        return false;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public static boolean isValidISBN13(String ISBN) {
        // check if valid isbn-13 form
        if (ISBN.length() == 17 && ISBN.matches("97[89]-\\d-\\d+-\\d+-\\d")) {
            // check digit
            int sum = 0, i = 0;
            for (char c : ISBN.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += (c - '0') * (i % 2 == 0 ? 1 : 3);
                    i++;
                }
            }

            int lastDigit = (ISBN.charAt(ISBN.length() - 1) - '0');
            sum -= lastDigit;
            return (10 - sum % 10) % 10 == lastDigit;
        }

        return false;
    }
}
