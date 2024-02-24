import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the first string
            System.out.print("Enter the first string: ");
            String str1 = scanner.nextLine();

            // Get the second string
            System.out.print("Enter the second string: ");
            String str2 = scanner.nextLine();

            // Check if the strings are anagrams
            if (areAnagrams(str1, str2)) {
                System.out.println("The strings are anagrams.");
            } else {
                System.out.println("The strings are not anagrams.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid strings.");
        } finally {
            scanner.close();
        }
    }

    private static boolean areAnagrams(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count the frequency of characters in the first string
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Decrement the frequency of characters in the second string
        for (char c : str2.toCharArray()) {
            int count = charCountMap.getOrDefault(c, 0);
            if (count == 0) {
                return false; // Character not present in the first string
            }
            charCountMap.put(c, count - 1);
        }

        return true;
    }
}
