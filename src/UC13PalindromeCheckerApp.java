import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;

public class UC13PalindromeCheckerApp {

    // Approach 1: Simple loop
    static boolean checkLoop(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0, end = cleaned.length() - 1;
        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Approach 2: StringBuilder reverse
    static boolean checkReverse(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // Approach 3: Stack
    static boolean checkStack(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) stack.push(c);
        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Approach 4: Deque
    static boolean checkDeque(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) return false;
        }
        return true;
    }

    // Approach 5: Recursive
    static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("  Welcome to Palindrome Checker  ");
        System.out.println("==================================");
        System.out.println("UC13 - Performance Comparison");
        System.out.println("----------------------------------");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("\n--- Performance Results ---");

        // Loop
        long start = System.nanoTime();
        boolean r1 = checkLoop(input);
        long end = System.nanoTime();
        System.out.println("Loop Approach      : " + r1 + " | Time: " + (end - start) + " ns");

        // Reverse
        start = System.nanoTime();
        boolean r2 = checkReverse(input);
        end = System.nanoTime();
        System.out.println("Reverse Approach   : " + r2 + " | Time: " + (end - start) + " ns");

        // Stack
        start = System.nanoTime();
        boolean r3 = checkStack(input);
        end = System.nanoTime();
        System.out.println("Stack Approach     : " + r3 + " | Time: " + (end - start) + " ns");

        // Deque
        start = System.nanoTime();
        boolean r4 = checkDeque(input);
        end = System.nanoTime();
        System.out.println("Deque Approach     : " + r4 + " | Time: " + (end - start) + " ns");

        // Recursive
        start = System.nanoTime();
        boolean r5 = checkRecursive(cleaned, 0, cleaned.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive Approach : " + r5 + " | Time: " + (end - start) + " ns");

        System.out.println("==================================");
        scanner.close();
    }
}