import java.util.Scanner;

public class PalindromeHello {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Normalize string
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", "");

        int start = 0;
        int end = str.length() - 1;
        boolean palindrome = true;

        while (start < end) {

            if (str.charAt(start) != str.charAt(end)) {
                palindrome = false;
                break;
            }

            start++;
            end--;
        }

        if (palindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}