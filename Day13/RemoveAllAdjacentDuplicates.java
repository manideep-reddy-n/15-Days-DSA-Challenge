package Day13;

import java.util.*;

public class RemoveAllAdjacentDuplicates {
    static String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == c) {
                st.peek().count++;
            } else {
                st.push(new Pair(c, 1));
            }
            if (st.peek().count == k) {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : st) {
            int count = p.count;
            while (count-- > 0) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(removeDuplicates(s, k));
    }

}

class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
