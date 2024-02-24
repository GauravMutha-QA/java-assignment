import java.util.InputMismatchException;
import java.util.Scanner;

interface NumberSwapper {
    void swapNumbers(double num1, double num2) throws InputMismatchException;
}

class WithTempVariable implements NumberSwapper {
    @Override
    public void swapNumbers(double num1, double num2) throws InputMismatchException {
        try {
            // Validate input
            validateInput(num1);
            validateInput(num2);

            // Swap with a temp variable
            double temp = num1;
            num1 = num2;
            num2 = temp;

            System.out.println("Numbers after swapping (with temp variable):");
            System.out.println("Num1: " + num1);
            System.out.println("Num2: " + num2);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input. Please enter valid numbers.");
        }
    }

    private void validateInput(double num) throws InputMismatchException {
        if (Double.isInfinite(num) || Double.isNaN(num)) {
            throw new InputMismatchException("Invalid input. Please enter a valid number.");
        }
    }
}

class WithoutTempVariable implements NumberSwapper {
    @Override
    public void swapNumbers(double num1, double num2) throws InputMismatchException {
        try {
            // Validate input
            validateInput(num1);
            validateInput(num2);

            // Swap without a temp variable
            num1 = num1 + num2;
            num2 = num1 - num2;
            num1 = num1 - num2;

            System.out.println("Numbers after swapping (without temp variable):");
            System.out.println("Num1: " + num1);
            System.out.println("Num2: " + num2);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input. Please enter valid numbers.");
        }
    }

    private void validateInput(double num) throws InputMismatchException {
        if (Double.isInfinite(num) || Double.isNaN(num)) {
            throw new InputMismatchException("Invalid input. Please enter a valid number.");
        }
    }
}

public class NumberSwapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get numbers from the user
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Create instances of implementing classes
            NumberSwapper withTempVariable = new WithTempVariable();
            NumberSwapper withoutTempVariable = new WithoutTempVariable();

            // Perform swapping with temp variable
            withTempVariable.swapNumbers(num1, num2);

            System.out.println(); // Separate the outputs

            // Perform swapping without temp variable
            withoutTempVariable.swapNumbers(num1, num2);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
