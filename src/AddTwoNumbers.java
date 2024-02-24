import java.util.InputMismatchException;
import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = 0;
        double num2 = 0;

        try {
            System.out.print("Enter the first number: ");
            if (scanner.hasNextInt()) {

                num1 = scanner.nextInt();

            } else if (scanner.hasNextDouble()) {

                num1 = scanner.nextDouble();

            }
            else if (scanner.hasNextFloat()) {

                num1 = scanner.nextFloat();


            } else {
                throw new InputMismatchException("Invalid input. Please enter valid numeric values.");
            }

            System.out.print("Enter the second number: ");

            if (scanner.hasNextInt()) {

                num2 = scanner.nextInt();

            } else if (scanner.hasNextDouble()) {

                num2 = scanner.nextDouble();

            } else if (scanner.hasNextFloat()) {

                num2 = scanner.nextFloat();

            } else {
                throw new InputMismatchException("Invalid input. Please enter valid numeric values.");
            }

            if (isInteger(num1) && isInteger(num2)) {
                int sum = addNumbers((int) num1, (int) num2);
                System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
            } else {
                double sum = addNumbers(num1, num2);
                System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double addNumbers(double a, double b) {
        return a + b;
    }

    private static int addNumbers(int a, int b) {
        return a + b;
    }

    private static boolean isInteger(double num) {
        return num == (int) num;
    }
}
