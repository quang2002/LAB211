
/**
 * @version 17/12/2021
 * @author yuyu
 */
public class Main {

    /**
     * sort method using bubble sort algorithm
     *
     * @param arr - the array that must be sort
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // if current element greater than next element then swap these two numbers
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * print out array of integer
     *
     * @param arr - array that will be print out
     */
    public static void display(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            // if this element is not the last element then print ', '
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * entry point of this program
     *
     * @param args
     */
    public static void main(String[] args) {
        int numberOfArray = Validation.getInteger("Enter number of array:\n", 0, Integer.MAX_VALUE);

        int[] arr = new int[numberOfArray];

        // generate random number from 0 to numberOfArray
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random() * arr.length);
        }

        System.out.print("Unsorted array: ");
        display(arr);

        sort(arr);

        System.out.print("Sorted array: ");
        display(arr);
    }
}
