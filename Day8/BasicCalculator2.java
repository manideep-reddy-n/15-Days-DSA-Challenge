package Day8;

import java.util.*;

public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                st.push(num);
                continue;
            }
            while (!op.isEmpty() && precedence(op.peek()) >= precedence(c)) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(result(n1, n2, op.pop()));
            }
            op.push(c);
            i++;
        }

        while (!op.isEmpty()) {
            int n2 = st.pop();
            int n1 = st.pop();
            st.push(result(n1, n2, op.pop()));
        }

        return st.pop();
    }

    public int result(int n1, int n2, char c) {
        switch (c) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
        }
        return 0;
    }

    public int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        BasicCalculator2 bc = new BasicCalculator2();
        System.out.println(bc.calculate(s));
    }
}
