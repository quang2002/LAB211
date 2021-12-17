
/**
 *
 * @author yuyu
 */
public class Main {

    /**
     * print out the number in binary representation
     *
     * @param num
     */
    public static void printBinary(int num) {
        if (num == 0) {
            System.out.print(0);
            return;
        }

        int[] arr = new int[32];
        int idx = arr.length - 1;

        while (num > 0) {
            arr[idx] = num % 2;
            num /= 2;
            idx--;
        }

        for (int i = idx + 1; i < 32; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        Validation vld = new Validation();

        int userChoice = vld.getBaseNumber("Your input base number: ");

        int number = 0;

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
                printBinary(number);
                break;
            case 2:
                System.out.print(number);
                break;
            case 3:
                System.out.printf("%X", number);
                break;
        }

        System.out.println();
    }
}
