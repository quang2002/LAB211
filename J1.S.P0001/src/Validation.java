
import java.util.Scanner;

public class Validation {

    public static int getInteger(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int result;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max) {
                    break;
                }
                System.err.println("Out of range");
            }
            catch (Exception e) {
                System.err.println("You must enter an integer");
            }
        }
        return result;
    }
}
