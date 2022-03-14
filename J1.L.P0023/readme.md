# LAB211 Assignment
## Title
    Create a Java console program to manage a Fruit Shop (Product and Shopping).
## Background
    Fruit Shop management system in java is basically developed for manage the Fruit Shop. In the Fruit Shop, product and Shopping management is very important. By making system is computerized it make possible to reduce effort, work is efficient and increase their revenue opportunities for shop owner.
## Program Specifications
The program provides shop owners tools to run their business effectively. The program’s functions as below:
**1. Main Screen as below:**  
**FRUIT SHOP SYSTEM**  
1. Create Fruit
2. Update Fruit
3. View orders
4. Shopping (for buyer)
5. Exit

**(Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).**  
**2. Function details:**  
* **2.1. For Fruit Shop owner**  
    **Create product (Fruit):**  
    * **A Fruit has attributes:** Fruit Id, Fruit Name, Price, Quantity and Origin.
    * From “Main Screen”, use select item (1) to create Fruit (Fruit Id must be enter). After each Fruit is created, the system shows message: Do you want to continue (Y/N)? User chooses Y to continues, if you chooses N, the program returns main screen and display all Fruits what are created.  
    
    **View orders**  
    * To view orders list, who buy and how many product

    ```
    Customer: Marry Carie
    Product     | Quantity | Price | Amount
    1. Apple        3	       1$	   3$
    2. Mango        2          2$      4$
    Total: 7$

    Customer: John Smith
    Product     | Quantity | Price | Amount
    1. JackFruit    3          3$	   9$
    2. Mango        2          2$      4$
    Total: 13$
    ```
* **2.2. Update Fruit**  
    * Enter Fruit ID, update Quantity if it exists, otherwise ask for create product (Yes/No: User choices ‘Yes’ to go to option 1, ‘No’ returns main screen. 
* **2.3. Shopping**  
    * Customer selects item 3, the program displays all fruits. For example:
    ```
    List of Fruit:
    | ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  	
           1 		    Coconut	        Vietnam	         2$
           2 		    Orange		      US		     3$
           3 		    Apple		    Thailand	     4$
           4 		    Grape		    France	         6$
    ```
    * To order, customer selects Item, for example: when customer selects item 1, the program shows:
    ```
    You selected: Coconut
    Please input quantity: 
    ```
    * After customer inputs quantity of fruit, the program shows message: Do you want to order now (Y/N). If customer selects N, the program returns to List of Fruit to continue ordering. If select Y, the program displays by Quantity descending order:
    ```
    Product | Quantity | Price | Amount
    Coconut       3	       2$	   6$
    Total: 6$
    Input your name: ...
    ```
    * Customer inputs his/her name to finish ordering. The program returns main screen.
## Technical Requirements
1. Using Object-Oriented programming style.
2. Use only core Java functions and classes.
3. Only use **ArrayList** and **HashTable** to store data (is required).
