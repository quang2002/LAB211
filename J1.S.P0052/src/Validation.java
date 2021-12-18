
import java.util.Scanner;

/**
 *
 * @author yuyu
 */
public class Validation {

    private Scanner sc;

    public Validation() {
        sc = new Scanner(System.in);
    }

    public int getInteger(String msg, int min, int max) {
        int result;

        while (true) {
            System.out.print(msg);
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (min <= result && result <= max) {
                    break;
                }
                System.err.println("Out of range");
            }
            catch (Exception e) {
                System.err.println("Wrong format - You must be enter an integer");
            }
        }

        return result;
    }

    public float getFloat(String msg, float min, float max) {
        Float result;

        while (true) {
            System.out.print(msg);
            try {
                result = Float.parseFloat(sc.nextLine().trim());
                if (min <= result && result <= max) {
                    break;
                }
                System.err.println("Out of range");
            }
            catch (Exception e) {
                System.err.println("Wrong format - You must be enter an floating-point");
            }
        }

        return result;
    }

    public String getString(String msg, String regex) {
        String result;

        while (true) {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.matches(regex)) {
                break;
            }
            System.err.println("This string not match the format");
        }

        return result;
    }
}
