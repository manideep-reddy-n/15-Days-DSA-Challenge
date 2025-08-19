package Day13;

import java.util.*;

public class AsteroidCollision {
    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int e : asteroids) {
            boolean flag = false;

            while (!st.isEmpty() && e < 0 && st.peek() > 0) {
                if (st.peek() < -e) {
                    st.pop();
                    continue;
                } else if (st.peek() == -e) {
                    st.pop();
                    flag = true;
                    break;
                } else {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                st.push(e);
            }
        }
        int[] ans = new int[st.size()];
        while (st.size() > 0) {
            ans[st.size() - 1] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(asteroidCollision(a)));
    }
}
