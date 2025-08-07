package Day6;

import java.util.*;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        SearchInsertPosition solution = new SearchInsertPosition();
        int result = solution.searchInsert(nums, target);
        System.out.println(result);
    }
}
