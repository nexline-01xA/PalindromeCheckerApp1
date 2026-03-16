import java.util.Scanner;

// PalindromeChecker class - Encapsulates palindrome logic
class PalindromeChecker {

    // Method to normalize string
    private String normalize(String str) {
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Single responsibility - only checks palindrome
    public boolean checkPalindrome(String str) {
        String cleaned = normalize(str);
        int start = 0, end = cleaned.length() - 1;
        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class UC11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("  Welcome to Palindrome Checker  ");
        System.out.println("==================================");
        System.out.println("UC11 - Object-Oriented Palindrome Service");
        System.out.println("Data Structure: Internal (Stack / Array)");
        System.out.println("----------------------------------");

        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("\"" + input + "\" IS a Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        System.out.println("==================================");
        scanner.close();
    }
}