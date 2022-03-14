# LAB211 Assignment
## Title
    HKT Book Store Management
## Background
    You were asked to build a book management application for the HKT store. The program must have the basic functions of adding, deleting and editing book information. The book.dat file is used to store information of all books in the store. The author.dat file has stored author information including authorID and name. 
    
    The relational model is shown as follows: one book can be written by only 1 author, one author can write many books.

    Support more functions: delete author, search by author name, real-time update processing.
## Program Specifications
    Build a management program. With the following basic functions:
        1. Build your data structure 
        2. Show the book list
        3. Add new book
        4. Update book
        5. Delete book
        6. Search book
            6.1. Search by book name
            6.2. Search by author name
        7. Store data to file
        8. Delete author
        9. Real time update processing
        Others- Quit
    
    Each menu choice should invoke an appropriate function to perform the selected menu item. Your program must display the menu after each task and wait for the user to select another option until the user chooses to quit the program. Each book has the properties such that ISBN, title, price and authorID. Each author has the following information: authorID, name. 
    
    The lecturer provides an author.dat file that contains information about 10 authors.

## Features
This system contains the following functions:  
* **Function 0: Build the data structure**
    * Classes, abstract classes, Interfaces.
    * bookID, authorID can not change after create.
    * Must implement the polymorphism properties of object-oriented programming. 
* **Function 1: Show the book list**
    * Show all data in the book.dat file into the screen.
* **Function 2: Add new book**
    * Create a submenu that allows the user add new book to the store. 
    * Remember that the constraints must be checked: bookID can not duplicate, author must be existed in the author list.
    * Add the new book to collection.
    * Ask to continuous create new animal or go back to the main menu.
* **Function 3: Update book**
    * Require enter the book id
    * If book does not exist, the notification “Book does not exist”. Otherwise, user can start input new information of book and update. 
    * If new information is blank, then not change old information.
    * Remember new information must be validated.
    * Then system must print out the result of the updating.
    * After updating, the program returns to the main screen.
* **Function 4: Delete Book**
    * User can delete any book in the store.
    * Before the delete system must show confirm message.
    * Show the result of the delete: success or fail.
    * After delete, the program returns to the main screen 
* **Function 5: Search book**
    * Create a submenu that allows the user to select way to search: search by author name or by book name.
    * **5.1. Search by book name:**
        * The user enters search text.
        * The system searches the store, and returns all book that has name contain the search text.
        * Show result list: all information of book.
    * **5.2. Search by author name:**
        * User input author name want to search.
        * The system will search in the store, and return all book that has author name is the search string.
        * Show result list: all information of book.
* **Function 6: Delete Author**
    * User can delete the author of book.
    * Before the delete system must show confirm message.
    * In the case, in the store that does not contain any book of this author then remove this author in author.dat file. On the contrary, the program displays the message "This author has a book in the store, you cannot delete this author". 
    * Show the result of the delete: success or fail.
    * After delete, the program returns to the main screen
* **Function 7: Store data to file**
    * Store data in collection to book.dat file.
* **Function 8: Real-time update processing**
    * Modify the above functions so that when each function is completed, the system must immediately update to the database.