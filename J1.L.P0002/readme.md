# LAB211 Assignment
## Title
    User Management – Read and Write File.
## Background
    A construction company needs a user information management program. With basic requirements such as register an account, display user information, update information, .... User information is stored in a text file (user.txt).
## Program Specifications
    Build a user management program. With the following basic functions:
        1. Create user account.
        2. Check exits user.
        3. Search user information by name.
        4. Update user:
            4.1. Update user.
            4.2. Delete user.
        7. Save account to file.
        8. Print list user from file.
        Others- Quit.
## Features
This system contains the following functions:  
* **Function 1: Create user account - 20 LOC**  
    * Require to input a user information include username, first name, last name, password, confirm, phone and email. 
    * Check the valid data with the following conditions:
        * Username must be at least five characters and no spaces.
        * Username is not allowed to duplicate in the database.
        * Password must be at least six characters and no spaces.
        * Confirm password must equal password.
        * Phone number must contain 10 numbers.
        * Email must follow standard email format.
    * Create new user.
    * Ask to go back the main menu.
* **Function 2: Check exist user – 20 LOC**  
    * The system will check the username that stored in the file user.txt.
    * A message “Exist User” should be displayed in the case the userName exists in the user.txt file. 
    * Otherwise, message “No User Found!” will display.
    * Ask to go back the main menu.
* **Function 3: Search user information by name – 20 LOC**  
    * Require enter a search string (a part of first name or last name), return a list user information contain search string.
    * If the list user is null, the notification "Have no any user", else print the list user information order by first name.
    * Ask to go back the main menu.
* **Function 4: Update user**
    * **Function 4.1: Update user information - 20 LOC**  
        * Login is required. 
        * If it does not exist, the notification "Username does not exist". Otherwise, user can edit of the remaining information. If Information is blank, then not change old information
        * Show the result of the update: success or fail.
        * Ask to go back to the main menu.
    * **Function 4.2: Delete user information – 20 LOC**  
        * Login is required. 
        * If it does not exist, the notification "Username does not exist". Otherwise, user can delete his account.
        * Show the result of the delete: success or fail
        * Ask to go back the main menu.
* **Function 5: Save to file - 20 LOC**  
    * Write list user’s information to the file (user.txt).
    * Ask to go back the main menu.
* **Function 6: Print all list from file – 20 LOC**  
    * Loading list user information from the file into Collection
    * Displaying list user information order by first name.
    * Ask to go back the main menu.
* **Function 7: Create layout – 20 LOC**  
    * The program is organized in the form of a function menu.
    * Support function asking if the user wants to continue or not.
* **Function 8: Password encryption – 20 LOC(Ext)**  
    * Encrypt password(SHA256) before saving to database. 