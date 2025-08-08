package Day7;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int[] ans = new int[nums.length - k + 1];
        for (int r = 0; r < nums.length; r++) {
            while (!q.isEmpty() && q.peekFirst() <= r - k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            if (r >= k - 1) {
                ans[i++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
