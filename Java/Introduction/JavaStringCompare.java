import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaStringCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.next();
        int myInt = scanner.nextInt();
        scanner.close();

        System.out.println(getSmallestAndLargest(myString, myInt));
    }

    // Complete the function
    // 'smallest' must be the lexicographically smallest substring of length 'k'
    // 'largest' must be the lexicographically largest substring of length 'k'
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        int small = 0;
        int big = 0;
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (i + k <= s.length()) {
                list.add(s.substring(i, i + k));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            small = list.get(i).compareTo(list.get(small)) > 0 ? small : i;
            big = list.get(i).compareTo(list.get(big)) > 0 ? i : big;
        }

        smallest = list.get(small);
        largest = list.get(big);

        return smallest + "\n" + largest;
    }
}
