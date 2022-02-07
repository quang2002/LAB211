/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package testjava;

import java.util.Scanner;

/**
 *
 * @author chall
 */
public class Product {

    // properties
    String productId;
    String productName;
    double unitPrice;
    int quantity;

    // methods
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        productId = sc.nextLine();

        System.out.print("Enter Product name: ");
        productName = sc.nextLine();

        System.out.print("Enter Unit price ($): ");
        unitPrice = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        quantity = sc.nextInt();
    }

    public void displayData() {
        System.out.println(productId + " - " + productName + " - " + unitPrice + " - " + quantity);
    }
}
