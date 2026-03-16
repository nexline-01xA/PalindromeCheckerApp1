

import java.util.Scanner;
public class UC10PalindromeCheckerApp {

    // Method to normalize string - remove spaces and convert to lowercase
    static String normalize(String str) {
        // Remove all non-alphanumeric characters and convert to lowercase
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Method to check palindrome
    static boolean isPalindrome(String str) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("  Welcome to Palindrome Checker  ");
        System.out.println("==================================");
        System.out.println("UC10 - Case-Insensitive & Space-Ignored Palindrome");
        System.out.println("Data Structure: String / Array");
        System.out.println("----------------------------------");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Original  : " + input);
        System.out.println("Normalized: " + normalize(input));

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" IS a Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        System.out.println("==================================");
        scanner.close();
    }
}