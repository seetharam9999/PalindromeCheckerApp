import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String text);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean checkPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.checkPalindrome(text);
    }
}

// Main class
public class PalindromeHello {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1-Stack, 2-Deque");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        if (context.checkPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}