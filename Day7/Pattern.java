package Day7;

import java.util.*;

public class Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int last = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < last) {
                return true;
            }
            while (!st.isEmpty() && st.peek() < nums[i]) {
                last = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Pattern solution = new Pattern();
        boolean result = solution.find132pattern(nums);
        System.out.println(result);
    }
}
