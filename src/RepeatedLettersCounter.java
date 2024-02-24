import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedLettersCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the input string
            System.out.print("Enter a string (only letters allowed): ");
            String inputString = getLettersOnlyInput(scanner);

            // Count the frequency of letters
            Map<Character, Integer> letterFrequencyMap = new HashMap<>();
            for (char c : inputString.toCharArray()) {
                letterFrequencyMap.put(c, letterFrequencyMap.getOrDefault(c, 0) + 1);
            }

            // Print repeated letters and their occurrences
            System.out.println("Repeated letters and their occurrences:");
            boolean hasRepeatedLetters = false;
            for (Map.Entry<Character, Integer> entry : letterFrequencyMap.entrySet()) {
                if (entry.getValue() > 1) {
                    hasRepeatedLetters = true;
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
                }
            }

            // Print a special message if no characters appear more than once
            if (!hasRepeatedLetters) {
                System.out.println("No characters appear more than once.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String getLettersOnlyInput(Scanner scanner) {
        String input = scanner.nextLine();

        if (!input.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Input must contain only letters.");
        }

        return input;
    }
}
