import java.util.Scanner;

public class PalindromeHello {

    static boolean checkPalindrome(String text) {

        int start = 0, end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (checkPalindrome(str))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}