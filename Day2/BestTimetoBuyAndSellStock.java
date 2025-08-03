import java.util.*;

public class BestTimetoBuyAndSellStock {
    static int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int[] he = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            he[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, he[i] - prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
    }

}
