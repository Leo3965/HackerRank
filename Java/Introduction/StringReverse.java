/*
 A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

 will consist at most  lower case english letters.
Sample Input

madam
Sample Output

Yes
*/

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        sc.close();
        System.out.println(isPalindrome(A) ? "Yes" : "No");
    }

    private static boolean isPalindrome(String a) {
        char[] chars = a.toCharArray();
        char[] reversed = new char[chars.length];

        int j = 0;
        for (int i = (chars.length - 1); i >= 0; i--) {
            reversed[j] = chars[i];
            j++;
        }

        String reverse = new String(reversed);

        return a.equals(reverse);
    }
}
