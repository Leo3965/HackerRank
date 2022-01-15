/*
Given a double-precision number, payment, denoting an amount of money,
use the NumberFormat class' getCurrencyInstance method to convert payment into the US,
Indian, Chinese, and French currency formats. Then print the formatted values as follows:

US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment

where formattedPayment is payment formatted according to the appropriate Locale's currency.

Note: India does not have a built-in Locale, so you must construct one where the language is en (i.e., English).

Input Format

A single double-precision number denoting payment.

Constraints
 0 ≤ payment ≤ 10⁹

On the first line, print US: u where u is payment formatted for US currency.
On the second line, print India: i where i is payment formatted for Indian currency.
On the third line, print China: c where c is payment formatted for Chinese currency.
On the fourth line, print France: f, where f is payment formatted for French currency.

Sample Input

12324.134
Sample Output

US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €
Explanation

Each line contains the value of payment formatted according to the four countries' respective currencies.
*/
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        Locale indiaLocale = new Locale("en", "IN");

        NumberFormat nfUs = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nfIn = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat nfCh = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nfFr = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        

        String us = nfUs.format(payment);
        String india = nfIn.format(payment);
        String china = nfCh.format(payment);
        String france = nfFr.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
