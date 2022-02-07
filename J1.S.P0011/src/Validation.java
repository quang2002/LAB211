
import java.math.BigInteger;
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
            } catch (Exception e) {
                System.err.println("You must enter your choice from 1 to 3");
            }
        }

        return result;
    }

    /**
     * get 32-bit binary string
     *
     * @param msg
     * @return
     */
    public BigInteger getBinary(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            if (input.matches("[01]+")) {
                return new BigInteger(input, 2);
            }
            System.err.println("You must enter an binary string");
        }
    }

    /**
     * get 8-digits hexadecimal number
     *
     * @param msg
     * @return
     */
    public BigInteger getHexadecimal(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            if (input.matches("[0-9A-Fa-f]+")) {
                return new BigInteger(input, 16);
            }
            System.err.println("You must enter an hexadecimal");
        }
    }

    /**
     * get decimal number
     *
     * @param msg
     * @return
     */
    public BigInteger getDecimal(String msg) {
        while (true) {
            System.out.println(msg);
            try {
                return new BigInteger(sc.nextLine());
            } catch (Exception e) {
                System.err.println("You must enter a decimal number");
            }
        }
    }
}
