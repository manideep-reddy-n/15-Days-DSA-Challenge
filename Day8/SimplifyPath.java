package Day8;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] ds = path.split("/");
        Stack<String> st = new Stack<>();
        System.out.println(Arrays.toString(ds));
        int n = ds.length;
        String ans = "";
        for (int i = 0; i < n; i++) {
            if (ds[i].isEmpty() || ds[i].equals("."))
                continue;

            if (ds[i].equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push("/" + ds[i]);
            }
        }
        for (String s : st) {
            ans += s;
        }
        return ans.isEmpty() ? "/" : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath(s));
    }

}
