package Day13;

import java.util.*;

public class MakeTheStringGreat {
    static String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty() && isSame(st.peek(), s.charAt(i))) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        String ans = "";
        for (char c : st) {
            ans += c;
        }
        return ans;
    }

    static boolean isSame(char a, char b) {
        return ((a - 'a' == b - 'A') || (a - 'A' == b - 'a'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(makeGood(s));
    }
}
