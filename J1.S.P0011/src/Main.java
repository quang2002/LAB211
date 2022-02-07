
import java.math.BigInteger;

/**
 *
 * @author yuyu
 */
public class Main {

    public static void main(String[] args) {
        Validation vld = new Validation();

        int userChoice = vld.getBaseNumber("Your input base number: ");

        BigInteger number = new BigInteger("0");

        switch (userChoice) {
            case 1:
                number = vld.getBinary("Enter a 32-bit binary string: ");
                break;
            case 2:
                number = vld.getDecimal("Enter a decimal number: ");
                break;
            case 3:
                number = vld.getHexadecimal("Enter a 8-digits hexdecimal number: ");
                break;
        }

        userChoice = vld.getBaseNumber("Your output base number: ");

        switch (userChoice) {
            case 1:
                System.out.print(number.toString(2));
                break;
            case 2:
                System.out.print(number.toString(10));
                break;
            case 3:
                System.out.print(number.toString(16));
                break;
        }

        System.out.println();
    }
}
