package Day5;

import java.util.*;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] > target)
                e = m - 1;
            else
                s = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        BinarySearch solution = new BinarySearch();
        int result = solution.search(nums, target);
        System.out.println(result);
    }

}
