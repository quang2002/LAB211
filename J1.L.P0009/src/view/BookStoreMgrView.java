/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package view;

import entity.Book;
import entity.Author;
import model.*;
import utilities.Input;
import utilities.StringHelper;

/**
 *
 * @author yuyu
 */
public class BookStoreMgrView {

    public void showTheBookList(Iterable<Book> list) {
        System.out.printf(
                "%4s | %20s | %30s | %10s | %10s | %30s\n",
                "#",
                "ISBN",
                "Title",
                "Price",
                "Author ID",
                "Author Name"
        );
        int i = 0;
        for (Book book : list) {
            i++;
            System.out.printf(
                    "%4d | %20s | %30s | %10s | %10s | %30s\n",
                    i,
                    book.getIsbn(),
                    book.getTitle(),
                    book.getPrice(),
                    book.getAuthor().getId(),
                    book.getAuthor().getName()
            );
        }
    }

    public void showTheAuthorList(Iterable<Author> list) {
        System.out.printf(
                "%4s | %10s | %30s\n",
                "#",
                "Author ID",
                "Author Name"
        );

        int i = 0;
        for (Author author : list) {
            i++;
            System.out.printf(
                    "%4d | %10d | %30s\n",
                    i,
                    author.getId(),
                    author.getName()
            );
        }
    }

    public void addNewBook(BookModel bookModel) {
        AuthorModel authorModel = bookModel.getAuthorModel();

        if (authorModel.size() <= 0) {
            System.out.println("Please register at least one author");
            return;
        }

        do {
            String ISBN = Input.getString("Enter ISBN: ", (value) -> {

                if (!Book.isValidISBN13(value)) {
                    System.out.println("Invalid ISBN-13. Re-Enter!");
                    return false;
                }

                if (bookModel.findByISBN(value) != null) {
                    System.out.println("This ISBN already exist!");
                    return false;
                }
                return true;
            });

            String title = Input.getString("Enter Title: ");

            float price = Input.getFloat("Enter Price: ", (value) -> {
                if (value < 0) {
                    System.out.println("Violation of check constraint: 0 <= Price");
                    return false;
                }
                return true;
            });

            showTheAuthorList(authorModel);

            int authorIndex = Input.getIntegerInclusive("Enter #Author: ", 1, authorModel.size()) - 1;
            Author author = authorModel.get(authorIndex);

            System.out.println(
                    bookModel.add(new Book(ISBN, title, price, author))
                    ? "Successful"
                    : "Failed"
            );
        } while (Input.getBoolean("Continue? (Y/N) "));
    }

    public void updateBook(BookModel bookModel) {
        if (bookModel.size() <= 0) {
            System.out.println("There is no book in store");
            return;
        }

        showTheBookList(bookModel);

        int bookIndex = Input.getIntegerInclusive("Enter #Book: ", 1, bookModel.size()) - 1;
        Book book = bookModel.get(bookIndex);

        Input.getString("Enter New Title: ", (value) -> {
            if (!value.trim().isEmpty()) {
                System.out.println(
                        "Update title -> " + value
                        + (book.setTitle(value)
                        ? ": Successful"
                        : ": Failed")
                );
            }
            return true;
        });

        Input.getString("Enter New Price: ", (value) -> {
            if (!value.trim().isEmpty()) {
                try {
                    float newPrice = Float.parseFloat(value);
                    if (newPrice < 0) {
                        System.out.println("Violation of check constraint: 0 <= Price");
                        return false;
                    }

                    System.out.println(
                            "Update price -> " + newPrice
                            + (book.setPrice(newPrice)
                            ? ": Successful"
                            : ": Failed")
                    );

                } catch (NumberFormatException e) {
                    System.out.println("Please Enter A Floating-point");
                    return false;
                }
            }
            return true;
        });

        AuthorModel authorModel = bookModel.getAuthorModel();

        showTheAuthorList(authorModel);

        Input.getString("Enter New #Author: ", (value) -> {
            if (!value.trim().isEmpty()) {
                try {
                    int authorID = Integer.parseInt(value);

                    if (1 > authorID || authorID > authorModel.size()) {
                        System.out.println("Invalid Author ID!");
                        return false;
                    }

                    Author author = authorModel.get(authorID - 1);

                    System.out.println(
                            "Update author -> "
                            + author.getName()+ (book.setAuthor(author)
                            ? ": Successful"
                            : ": Failed")
                    );

                } catch (NumberFormatException e) {
                    System.out.println("Please Enter An Integer");
                    return false;
                }
            }
            return true;
        });
    }

    public void deleteBook(BookModel bookModel) {
        if (bookModel.size() <= 0) {
            System.out.println("There is no book in store");
            return;
        }

        showTheBookList(bookModel);

        int bookIndex = Input.getIntegerInclusive("Enter #Book: ", 1, bookModel.size()) - 1;
        Book book = bookModel.get(bookIndex);

        if (Input.getBoolean("Confirm? (Y/N) ")) {
            System.out.println(
                    bookModel.remove(book)
                    ? "Successful"
                    : "Failed"
            );
        } else {
            System.out.println("Cancel");
        }
    }

    public interface SearchCondition {

        public boolean check(Book book, Object seachParam);
    }

    public void searchBook(BookModel bookModel, SearchCondition condition) {
        if (bookModel.size() <= 0) {
            System.out.println("There is no book in store");
            return;
        }

        String searchText = StringHelper.VN2EN(Input.getString("Enter Search Text: ").toLowerCase().trim());

        System.out.printf(
                "%4s | %20s | %30s | %10s | %10s | %30s\n",
                "#",
                "ISBN",
                "Title",
                "Price",
                "Author ID",
                "Author Name"
        );
        int i = 0;
        for (Book book : bookModel) {
            i++;
            if (condition.check(book, searchText)) {
                System.out.printf(
                        "%4d | %20s | %30s | %10s | %10s | %30s\n",
                        i,
                        book.getIsbn(),
                        book.getTitle(),
                        book.getPrice(),
                        book.getAuthor().getId(),
                        book.getAuthor().getName()
                );
            }
        }
    }

    public void searchBookByTitle(BookModel bookModel) {
        searchBook(bookModel, (book, searchText) -> {
            return StringHelper.VN2EN(book.getTitle().toLowerCase()).contains(searchText.toString());
        });
    }

    public void searchBookByAuthorName(BookModel bookModel) {
        searchBook(bookModel, (book, searchText) -> {
            return StringHelper.VN2EN(book.getAuthor().getName()).equalsIgnoreCase(searchText.toString());
        });
    }

    public void deleteAuthor(AuthorModel authorModel) {
        if (authorModel.size() <= 0) {
            System.out.println("Please register at least one author");
            return;
        }

        showTheAuthorList(authorModel);

        int authorIndex = Input.getIntegerInclusive("Enter #Author: ", 1, authorModel.size()) - 1;
        Author author = authorModel.get(authorIndex);

        if (Input.getBoolean("Confirm? (Y/N)")) {
            System.out.println(
                    authorModel.remove(author)
                    ? "Success"
                    : "This author has a book in the store, you cannot delete this author"
            );
        } else {
            System.out.println("Cancel");
        }
    }
}
