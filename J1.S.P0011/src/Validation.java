
import java.util.Scanner;

/**
 *
 * @author yuyu
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    /**
     * get the base number
     *
     * @param msg message for user
     * @return 1 for binary 2 for decimal 3 for hexadecimal
     */
    public int getBaseNumber(String msg) {
        int result;
        System.out.println(msg);
        System.out.println("1. binary\n2. decimal\n3. hexadecimal");

        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result >= 1 && result <= 3) {
                    break;
                }
                System.err.println("You must enter your choice from 1 to 3");
            }
            catch (Exception e) {
                System.err.println("You must enter your choice from 1 to 3");
            }
        }

        return result;
    }

    /**
     * get 32-bit binary string
     * @param msg
     * @return 
     */
    public int getBinary(String msg) {
        int result = 0;
        System.out.println(msg);

        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches("[01]+")) {
                if (input.length() > 32) {
                    System.err.println("You must enter an 32-bit binary string");
                    continue;
                }

                for (char c : input.toCharArray()) {
                    result *= 2;
                    result += (c - '0');
                }
                break;
            }
            System.err.println("You must enter an binary string");
        }

        return result;
    }

    /**
     * get 8-digits hexadecimal number
     * @param msg
     * @return 
     */
    public int getHexadecimal(String msg) {
        int result = 0;
        System.out.println(msg);

        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches("[0-9A-Fa-f]+")) {
                if (input.length() > 32) {
                    System.err.println("You must enter an 8-digits hexadecimal");
                    continue;
                }

                for (char c : input.toCharArray()) {
                    result *= 16;
                    if (Character.isDigit(c)) {
                        result += (c - '0');
                    }
                    else {
                        result += (Character.toUpperCase(c) - 'A' + 10);
                    }
                }
                break;
            }
            System.err.println("You must enter an hexadecimal");
        }

        return result;
    }

    /**
     * get decimal number
     * @param msg
     * @return 
     */
    public int getDecimal(String msg) {
        int result;
        System.out.println(msg);

        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
                break;
            }
            catch (Exception e) {
                System.err.println("You must enter a decimal number");
            }
        }

        return result;
    }
}
