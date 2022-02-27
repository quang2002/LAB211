
import controller.BookStoreMgr;
import utilities.Input;

public class Main {

    public static int getChoice() {
        System.out.println("\n\n=================== HKT Book Store Management ===================");
        System.out.println("1. Show the book list");
        System.out.println("2. Add new book");
        System.out.println("3. Update book");
        System.out.println("4. Delete book");
        System.out.println("5. Delete author");
        System.out.println("6. Search book");
        System.out.println("0. Exit");

        return Input.getIntegerInclusive("Enter your choice: ", 0, 6);
    }

    public static int getSearchChoice() {
        System.out.println("\n\n========================== Search Book ==========================");
        System.out.println("1. Search by book title");
        System.out.println("2. Search by author name");
        System.out.println("0. Exit");

        return Input.getIntegerInclusive("Enter your choice: ", 0, 2);
    }

    public static void main(String[] args) {
        BookStoreMgr bsm = new BookStoreMgr();

        while (true) {
            int choice = getChoice();

            switch (choice) {
                case 1: {
                    bsm.showTheBookList();
                    break;
                }
                case 2: {
                    bsm.addNewBook();
                    break;
                }
                case 3: {
                    bsm.updateBook();
                    break;
                }
                case 4: {
                    bsm.deleteBook();
                    break;
                }
                case 5: {
                    bsm.deleteAuthor();
                    break;
                }
                case 6: {
                    int searchChoice = getSearchChoice();
                    if (searchChoice == 1) {
                        bsm.searchBookByTitle();
                    } else if (searchChoice == 2) {
                        bsm.searchBookByAuthorName();
                    }
                    break;
                }
                case 0: {
                    bsm.closeConnection();
                    System.out.println("Terminate...");
                    return;
                }
            }
        }
    }
}
