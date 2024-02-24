import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the size of the array
            System.out.print("Enter the size of the array: ");
            int size = getPositiveIntegerInput(scanner);

            // Get the elements of the array
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                array[i] = getNumericInput(scanner);
            }

            // Sort the array in non-decreasing order
            Arrays.sort(array);

            // Get the value to be searched for
            System.out.print("Enter the value to be searched for: ");
            double target = getNumericInput(scanner);

            // Perform binary search
            int result = binarySearch(array, target);

            // Display the result
            if (result != -1) {
                System.out.println("Element " + target + " found at index " + result);
            } else {
                System.out.println("Element " + target + " not found in the array.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int binarySearch(double[] array, double target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid; // Element found
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Element not found
    }

    private static int getPositiveIntegerInput(Scanner scanner) {
        try {
            int input = scanner.nextInt();

            if (input <= 0) {
                throw new InputMismatchException("Size must be a positive integer.");
            }

            return input;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            throw new InputMismatchException("Invalid input. Please enter a positive integer.");
        }
    }

    private static double getNumericInput(Scanner scanner) {
        try {
            double input = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            return input;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            throw new InputMismatchException("Invalid input. Please enter a valid number.");
        }
    }
}
