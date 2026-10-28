import java.util.*;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        // If the amount is zero, no coins are needed.
        if (amount == 0) return 0;

        // dp[i] stores the minimum number of coins required
        // to make the amount i.
        // A value of -1 indicates that the amount
        // cannot be formed using the available coins.
        int[] dp = new int[amount + 1];

        // Initially, assume that no positive amount
        // can be formed.
        Arrays.fill(dp, -1);

        // Base case:
        // Zero coins are required to make amount zero.
        dp[0] = 0;

        // Calculate the minimum coins required for
        // every amount from 1 to the target amount.
        for (int i = 1; i <= amount; i++) {

            // Try every available coin to form amount i.
            for (int coin : coins) {

                // Skip the coin if it exceeds the current amount.
                if (coin > i) continue;

                // If the remaining amount cannot be formed,
                // this coin cannot produce a valid solution.
                if (dp[i - coin] == -1) continue;

                // Include the current coin.
                // Total coins = minimum coins for the remaining
                // amount + 1 for the current coin.
                int ans = dp[i - coin] + 1;

                // If this is the first valid way to form amount i,
                // store the result.
                if (dp[i] == -1) {
                    dp[i] = ans;
                }

                // Otherwise, keep the minimum coin count
                // among all valid combinations.
                else {
                    dp[i] = Math.min(dp[i], ans);
                }
            }
        }

        // Return the minimum number of coins needed
        // to form the target amount.
        // Returns -1 if the amount cannot be formed.
        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange solution = new CoinChange();

        System.out.println(
            "Minimum Coins: " + solution.coinChange(coins, amount)
        );

        // Output: Minimum Coins: 3
        // Explanation: 11 = 5 + 5 + 1
    }
}