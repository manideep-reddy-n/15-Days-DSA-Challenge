package Day3;

import java.util.*;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    static int strStr(String haystack, String needle) {
        int n = needle.length();
        for (int i = 0; i <= haystack.length() - n; i++) {
            if (haystack.substring(i, i + n).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        System.out.println(strStr(haystack, needle));
    }
}
