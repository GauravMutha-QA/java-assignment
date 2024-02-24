import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AllOddOrEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the size of the list
            System.out.print("Enter the size of the list: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                throw new InputMismatchException("Invalid input. The size of the list must be a positive integer.");
            }

            // Get the numbers in the list
            List<Integer> numbers = new ArrayList<>();
            System.out.println("Enter the numbers in the list (decimals will be rounded off to the nearest integer):");
            for (int i = 0; i < size; i++) {
                try {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    if (scanner.hasNextInt()) {
                        numbers.add(scanner.nextInt());
                    } else {
                        throw new InputMismatchException("Invalid input. Please enter valid integers.");
                    }
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Invalid input. Please enter valid integers.");
                }
            }

            // Process the list
            if (containsOnlyOdd(numbers)) {
                System.out.println("The list contains only odd numbers.");
            } else if (containsOnlyEven(numbers)) {
                System.out.println("The list contains only even numbers.");
            } else {
                System.out.println("The list contains a mix of odd and even numbers.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. The size of the list must be a positive integer.");
        } finally {
            scanner.close();
        }
    }

    private static boolean containsOnlyOdd(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsOnlyEven(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
