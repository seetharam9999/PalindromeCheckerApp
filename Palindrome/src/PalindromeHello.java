import java.util.*;

public class PalindromeHello {

    // Stack-based palindrome
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }

    // Deque-based palindrome
    public static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    // Simple iterative palindrome
    public static boolean iterativePalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) if (str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }

    // Recursive palindrome
    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Stack Strategy
        long startTime = System.nanoTime();
        stackPalindrome(input);
        long endTime = System.nanoTime();
        System.out.println("Stack-based: " + (endTime - startTime) + " ns");

        // Deque Strategy
        startTime = System.nanoTime();
        dequePalindrome(input);
        endTime = System.nanoTime();
        System.out.println("Deque-based: " + (endTime - startTime) + " ns");

        // Iterative Strategy
        startTime = System.nanoTime();
        iterativePalindrome(input);
        endTime = System.nanoTime();
        System.out.println("Iterative: " + (endTime - startTime) + " ns");

        // Recursive Strategy
        startTime = System.nanoTime();
        recursivePalindrome(input, 0, input.length() - 1);
        endTime = System.nanoTime();
        System.out.println("Recursive: " + (endTime - startTime) + " ns");

        sc.close();
    }
}