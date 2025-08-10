package Day8;

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int n = s.length();
        String str = "";
        String result = "";
        int i;
        for (i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ']') {
                st.push(c + "");
            } else if (c == '[') {
                while (!st.isEmpty() && !st.peek().equals("]")) {
                    str += st.pop();
                }
                if (!st.isEmpty())
                    st.pop();
            } else if (Character.isDigit(c)) {
                String temp = "";
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    temp = s.charAt(i) + "" + temp;
                    i--;
                }
                i++;
                int dig = Integer.parseInt(temp);
                for (int j = 0; j < dig; j++) {
                    result = str + result;
                }
                st.push(result);
                result = "";
                str = "";
            } else {
                st.push(c + "");
            }
        }
        while (!st.isEmpty()) {
            str += st.pop();
        }
        result = result + str;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(s));
    }
}
