package Day11;

import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] min = new int[amount + 1];
        Arrays.fill(min, amount + 1);
        min[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    min[i] = Math.min(min[i], 1 + min[i - c]);
                }
            }
        }
        return min[amount] != amount + 1 ? min[amount] : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(coins, amount));
    }
}
