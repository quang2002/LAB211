/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package Utilities;

import java.util.Scanner;

/**
 *
 * @author yuyu
 */
public class Validation {

    public static int getInteger(String msg, ValidationChecker<Integer> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            }
            catch (Exception e) {
                System.err.println("You must enter an integer");
            }
        }
    }

    public static float getFloat(String msg, ValidationChecker<Float> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                float result = Float.parseFloat(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            }
            catch (Exception e) {
                System.err.println("You must enter a floating-point number");
            }
        }
    }

    public static String getString(String msg, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = scanner.nextLine().trim();
            if (regex.isEmpty() || result.matches(regex)) {
                return result;
            }
            System.err.println("Your string entered not match with regex");
        }
    }

    public static String getString(String msg, ValidationChecker<String> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = scanner.nextLine().trim();
            if (checker == null || checker.checker(result)) {
                return result;
            }
        }
    }
}
