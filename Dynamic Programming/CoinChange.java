
import java.util.Arrays;

public class Q4_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int INF = amount + 1; // larger than possible
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] = Math.min(dp[a], dp[a - coin] + 1);
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11)); // 3 (5+5+1)
        System.out.println(coinChange(new int[]{2}, 3)); // -1
    }
}

/*
 Time: O(amount * k) where k = number of coins
 Space: O(amount)
 Note: Another loop order (for a then coin) yields same correctness; this one iterates coins outer to show unbounded use.
*/
