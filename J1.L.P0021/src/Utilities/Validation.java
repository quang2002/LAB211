package Utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

    private Scanner sc;

    public void clearBuffer() {
        sc = new Scanner(System.in);
    }

    public Integer getInteger(String msg, Integer min, Integer max, boolean isLoop) {
        return get(msg, min, max, isLoop);
    }

    public Integer getInteger(String msg, boolean isLoop) {
        return getInteger(msg, Integer.MIN_VALUE, Integer.MAX_VALUE, isLoop);
    }

    public Double getDouble(String msg, Double min, Double max, boolean isLoop) {
        return get(msg, min, max, isLoop);
    }

    public Double getDouble(String msg, boolean isLoop) {
        return getDouble(msg, Double.MIN_VALUE, Double.MAX_VALUE, isLoop);
    }

    public <E> E get(String msg, E min, E max, boolean isLoop) {
        E result = null;

        do {
            System.out.print(msg);
            clearBuffer();

            try {
                if (result instanceof Integer) {
                    int value = Integer.parseInt(sc.nextLine().trim());
                    result = (E) new Integer(value);

                    if ((Integer) min <= value && value <= (Integer) max) {
                        break;
                    }
                }
                else if (result instanceof Double) {
                    double value = Double.parseDouble(sc.nextLine().trim());
                    result = (E) new Double(value);

                    if ((Double) min <= value && value <= (Double) max) {
                        break;
                    }
                }

                System.err.println("Out of range");
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.err.println("You must enter a number");
            }
        }
        while (isLoop);

        return result;
    }

    public Boolean getBoolean(String msg, boolean isLoop) {
        Boolean result = null;

        do {
            System.out.print(msg);
            clearBuffer();

            try {
                result = Boolean.parseBoolean(sc.nextLine().trim());
                break;
            }
            catch (Exception e) {
                System.err.println("You must enter an boolean");
            }
        }
        while (isLoop);

        return result;
    }

    public String getString(String msg, String regex, boolean isLoop) {
        String result = null;

        do {
            System.out.print(msg);
            clearBuffer();

            try {
                result = sc.nextLine();
                if (result.trim().isEmpty()) {
                    System.err.println("You must enter a not empty string");
                }
                else if (result.matches(regex)) {
                    System.err.println("Wrong format: " + regex);
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.err.println("You must enter a string");
            }
        }
        while (isLoop);

        return result;
    }
}
