# LAB211 Assignment
## Title
    The Secret Bank.
## Background
    Mr. Khanh wants to build a secret bank. Each person can create a bank account, deposit, withdraw, transfer or remove the account. In addition, this bank must support a login function. The password must be encrypted before saving to the database. Mr Khanh's Bank uses binary files as a database. File bank.dat is used to store all accounts and their money in the bank. The user.dat file is used to store all accounts and passwords.
## Program Specifications
    Build a management program. With the following basic functions:
        1. Create new account
        2. Login function
        3. Withdrawal function
        4. Deposit function
        5. Transfer money
        6. Remove account
        Others- Quit
    Each menu choice should invoke an appropriate function to perform the selected menu item.  Your program must display the menu after each task and wait for the user to select another option until the user chooses to quit the program.
## Features
This system contains the following functions:  
* **Function 1: Create new Account - 30 LOC**  
    * User input account id, account name, password, confirm password.
    * The system will check the constraints: this account is not registered in the system, the password must contain at least 6 characters, including uppercase letters, lower case letters, numeric characters and 1 special character. The two passwords must be the same.
    * All data must be validated. Otherwise, an error message will be displayed.
    * Password must be encrypted before saving to the database.
    * After create new account then go back to the main menu
* **Function 2: Login function - 30 LOC**
    * In order to access the bank management, an authentication is required.
    * The user enters account ID and password, the function checks if the account ID and password is correct, then grant the access permission. If not, a message would appear no notify that user is not found.
    * If login is successful, then user can use the bellow functions
    * Go back to the main menu.
* **Function 3: Withdraw function - 30 LOC**
    * Login is required.
    * Require enter the amount money want to withdraw. 
    * The program will check: if the amount to be withdrawn exceeds the amount in the account, the error message will be shown. Otherwise, the program accepts withdrawal and updates the remaining amount in the account.
    * After withdraw, the program returns to the main screen.
* **Function 4: Deposit function - 30 LOC**
    * Login is required.
    * Require enter the amount money want to deposit. 
    * The program will show a confirmation message amount of money wants to deposit. If the user confirms 'Yes', then make a deposit to the account - update the balance in the account. If the user confirms 'No' then cancel the deposit.
    * After deposit, the program returns to the main screen.
* **Function 5: Transfer money - 30 LOC**
    * Login is required.
    * Require enter the receive account and amount money want to transfer. 
    * The program will check whether the recipient account exists or not. If the recipient account does not exist an error message is displayed, Otherwise, the name of the recipient account is displayed.
    * The program will check if the amount you want to transfer is greater than the balance in your account. If the amount you want to transfer is greater than the balance in your account, the error message will be reported.
    * After all the constraints are validated, the program will show a confirmation message. If the user confirms 'Yes', then make a transfer. If the user confirms 'No' then cancel the transfer
    * The transfer: update the receiver's balance, update the balance of the sender.
    * After transfer, the program returns to the main screen.
* **Function 6: Remove account - 25 LOC**
    * Login is required.
    * The program will show a confirmation message. If the user confirms 'Yes', then remove this account and logout this account. If the user confirms 'No' then cancel the remove.
    * After remove, the program returns to the main screen.