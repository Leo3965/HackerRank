/*
Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Function Description

Complete the isAnagram function in the editor.

isAnagram has the following parameters:

string a: the first string
string b: the second string
Returns

boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
Input Format

The first line contains a string .
The second line contains a string .

Constraints

Strings  and  consist of English alphabetic characters.
The comparison should NOT be case sensitive.
Sample Input 0

anagram
margana
Sample Output 0

Anagrams
Explanation 0

Character	Frequency: anagram	Frequency: margana
A or a	3	3
G or g	1	1
N or n	1	1
M or m	1	1
R or r	1	1
The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

Sample Input 1

anagramm
marganaa
Sample Output 1

Not Anagrams
Explanation 1

Character	Frequency: anagramm	Frequency: marganaa
A or a	3	4
G or g	1	1
N or n	1	1
M or m	2	1
R or r	1	1
The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".

Sample Input 2

Hello
hello
Sample Output 2

Anagrams
Explanation 2

Character	Frequency: Hello	Frequency: hello
E or e	1	1
H or h	1	1
L or l	2	2
O or o	1	1
The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
*/

import java.io.*;
import java.util.*;

public class JavaAnagrams {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        var isAnagram = formatResponse(isAnagram(a, b));
        System.out.println(isAnagram);

        scanner.close();
    }

    private static Boolean isAnagram(String firstPhrase, String secondPhrase) {
        if (firstPhrase.length() != secondPhrase.length()) return false;

        firstPhrase = toLowerCase(firstPhrase);
        secondPhrase = toLowerCase(secondPhrase);

        Map<String, Integer> firstPhraseMap = new HashMap<>();
        Map<String, Integer> secondPhraseMap = new HashMap<>();
        int length = firstPhrase.length();

        for (int i = 0; i < length; i++) {
            String fKey = String.valueOf(firstPhrase.charAt(i));
            String sKey = String.valueOf(secondPhrase.charAt(i));

            updateMap(firstPhraseMap, fKey);
            updateMap(secondPhraseMap, sKey);
        }

        return isMapEqual(firstPhraseMap, secondPhraseMap);
    }

    private static String toLowerCase(String phrase) {
        return phrase.trim().toLowerCase();
    }

    private static void updateMap(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private static Boolean isMapEqual(Map<String, Integer> firstMap, Map<String, Integer> secondMap) {
        for (var letter : firstMap.entrySet()) {
            var fLetter = letter.getValue();
            var sLetter = secondMap.get(letter.getKey());
            if (fLetter != sLetter) return false;
        }

        return true;
    }

    private static String formatResponse(Boolean isEqual) {
        return isEqual ? "Anagrams" : "Not Anagrams";
    }

}
