/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package utilities;

import java.util.Scanner;

/**
 *
 * @author yuyu
 */
public class Input {

    /**
     * Get an integer from user in range (min, max)
     *
     * @param msg message
     * @param min min value
     * @param max max value
     * @return user input integer
     */
    public static int getIntegerExclusive(String msg, int min, int max) {
        return getInteger(msg, (value) -> {
            if (min < value && value < max) {
                return true;
            }
            System.err.println("Out of range: (" + min + ", " + max + ")");
            return false;
        });
    }

    /**
     * Get an integer from user in range [min, max]
     *
     * @param msg message
     * @param min min value
     * @param max max value
     * @return user input integer
     */
    public static int getIntegerInclusive(String msg, int min, int max) {
        return getInteger(msg, (value) -> {
            if (min <= value && value <= max) {
                return true;
            }
            System.err.println("Out of range: [" + min + ", " + max + "]");
            return false;
        });
    }

    /**
     * Get an integer from user, without condition
     *
     * @param msg message
     * @return user input integer
     */
    public static int getInteger(String msg) {
        return getInteger(msg, null);
    }

    /**
     * Get a integer from user, with custom condition
     *
     * @param msg message
     * @param checker callback for check value after input
     * @return input integer
     */
    public static int getInteger(String msg, ValidationChecker<Integer> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("You must enter an integer");
            }
        }
    }

    /**
     * Get a floating-point number from user, in range (min, max)
     *
     * @param msg message
     * @param min min value
     * @param max max value
     * @return
     */
    public static float getFloatExclusive(String msg, float min, float max) {
        return getFloat(msg, (value) -> {
            if (min < value && value < max) {
                return true;
            }
            System.err.println("Out of range: (" + min + ", " + max + ")");
            return false;
        });
    }

    /**
     * Get a floating-point number from user, in range [min, max]
     *
     * @param msg message
     * @param min min value
     * @param max max value
     * @return
     */
    public static float getFloatInclusive(String msg, float min, float max) {
        return getFloat(msg, (value) -> {
            if (min <= value && value <= max) {
                return true;
            }
            System.err.println("Out of range: [" + min + ", " + max + "]");
            return false;
        });
    }

    /**
     * Get a floating-point number from user, without condition
     *
     * @param msg
     * @return
     */
    public static float getFloat(String msg) {
        return getFloat(msg, null);
    }

    /**
     * Get a floating-point number from user, with custom condition
     *
     * @param msg message
     * @param checker callback for check value after input
     * @return
     */
    public static float getFloat(String msg, ValidationChecker<Float> checker) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                float result = Float.parseFloat(scanner.nextLine());

                if (checker == null || checker.checker(result)) {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("You must enter a floating-point number");
            }
        }
    }

    /**
     * Get string from user, with check
     *
     * @param msg
     * @param checker
     * @return
     */
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

    /**
     * Get a line from user, not blank
     *
     * @param msg
     * @return
     */
    public static String getString(String msg) {
        return getString(msg, "");
    }

    /**
     * Get a line form user, must be match with 'regex'
     *
     * @param msg
     * @param regex
     * @return
     */
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

    /**
     * Get boolean form user, correspond with set of true values and false
     * values
     *
     * @param msg message
     * @param trueValues set of true values, separate by |
     * @param falseValues set of false values, separate by |
     * @return
     */
    public static boolean getBoolean(String msg, String trueValues, String falseValues) {
        String[] trues = trueValues.split("\\|");
        String[] falses = falseValues.split("\\|");

        if (trues.length == 0) {
            return false;
        }

        if (falses.length == 0) {
            return true;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = scanner.nextLine().trim();

            for (String aTrue : trues) {
                if (result.equalsIgnoreCase(aTrue)) {
                    return true;
                }
            }

            for (String aFalse : falses) {
                if (result.equalsIgnoreCase(aFalse)) {
                    return false;
                }
            }

            System.err.println("Your string entered not match with any value");
        }
    }

    /**
     * Get boolean with set of true values are {y, yes, ok, yep, 1}; false
     * values are {n, no, nop, nope, 0}
     *
     * @param msg
     * @return
     */
    public static boolean getBoolean(String msg) {
        return getBoolean(msg, "y|yes|ok|yep|1", "n|no|nop|nope|0");
    }
}
