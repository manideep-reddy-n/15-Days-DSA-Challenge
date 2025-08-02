import java.util.*;

public class MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}