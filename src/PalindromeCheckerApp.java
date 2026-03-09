import java.util.Scanner;

public class PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert string to linked list, returns head node
    static Node convertToLinkedList(String str) {
        Node head = null, tail = null;
        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Find middle using Fast & Slow pointer technique
    static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // moves 1 step
            fast = fast.next.next;  // moves 2 steps
        }
        return slow; // slow is at middle
    }

    // Reverse a linked list in-place
    static Node reverseList(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of reversed list
    }

    // Check palindrome using linked list
    static boolean isPalindrome(String str) {
        // Step 1: Convert string to linked list
        Node head = convertToLinkedList(str);

        // Step 2: Find middle of linked list
        Node middle = findMiddle(head);

        // Step 3: Reverse second half
        Node secondHalfHead = reverseList(middle);

        // Step 4: Compare first and second halves
        Node left = head;
        Node right = secondHalfHead;
        boolean result = true;

        while (right != null) {
            if (left.data != right.data) {
                result = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("  UC8: Linked List Based Palindrome Checker  ");
        System.out.println("==============================================");

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Clean input: lowercase, remove non-alphanumeric
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("Original Input  : " + input);
        System.out.println("Cleaned String  : " + cleaned);

        if (cleaned.isEmpty()) {
            System.out.println("Result          : Invalid input.");
        } else {
            boolean result = isPalindrome(cleaned);
            System.out.println("Result          : \"" + input + "\" is "
                    + (result ? "" : "NOT ") + "a Palindrome!");
        }

        scanner.close();
    }
}