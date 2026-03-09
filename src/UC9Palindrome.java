static boolean isPalindromeRecursive(String s, int start, int end) {
    if (start >= end) return true;
    if (s.charAt(start) != s.charAt(end)) return false;
    return isPalindromeRecursive(s, start + 1, end - 1);
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String input = sc.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");
    boolean result = isPalindromeRecursive(input, 0, input.length() - 1);
    System.out.println(result ? "Palindrome" : "Not a Palindrome");
}
