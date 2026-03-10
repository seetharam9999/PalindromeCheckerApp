import java.util.*;

public class PalindromeHello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters into Queue and Stack
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);   // Enqueue
            stack.push(ch);  // Push
        }

        boolean isPalindrome = true;

        System.out.println("\nComparing Queue (FIFO) and Stack (LIFO):");

        while (!queue.isEmpty()) {
            char qChar = queue.remove(); // Dequeue
            char sChar = stack.pop();    // Pop

            System.out.println("Queue Dequeue: " + qChar + " | Stack Pop: " + sChar);

            if (qChar != sChar) {
                isPalindrome = false;
            }
        }

        // Result
        if (isPalindrome) {
            System.out.println("\nThe word is a Palindrome.");
        } else {
            System.out.println("\nThe word is NOT a Palindrome.");
        }

        sc.close();
    }
}