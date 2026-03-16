import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String str);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }
        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
}

// Context class - injects strategy at runtime
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String str) {
        return strategy.check(str);
    }
}

public class UC12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("  Welcome to Palindrome Checker  ");
        System.out.println("==================================");
        System.out.println("UC12 - Strategy Pattern Palindrome");
        System.out.println("----------------------------------");
        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
            System.out.println("Using: Stack Strategy");
        } else {
            strategy = new DequeStrategy();
            System.out.println("Using: Deque Strategy");
        }

        PalindromeContext context = new PalindromeContext(strategy);

        if (context.executeStrategy(input)) {
            System.out.println("\"" + input + "\" IS a Palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        System.out.println("==================================");
        scanner.close();
    }
}