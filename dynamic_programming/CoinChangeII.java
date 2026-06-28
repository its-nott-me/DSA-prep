/*
    Problem: Coin Change II

    Description:
    Given an array of distinct coin denominations and a target amount,
    return the number of distinct combinations that make up the amount.

    You have an unlimited supply of each coin.

    Since the answer can be large, return it modulo 1,000,000,007.

    Approach: 1D Dynamic Programming

    Time Complexity: O(n * amount)
    Space Complexity: O(amount)

    Key Idea:
    - Let dp[i] represent the number of ways to make amount i.
    - Initialize dp[0] = 1 since there is exactly one way to make
      amount 0 (choose no coins).
    - Process each coin one by one.
    - For every coin, update all amounts from coin to target:
          dp[j] += dp[j - coin]
      because every way to make (j - coin) can be extended by
      adding the current coin.
    - The outer loop iterates over coins, ensuring each combination
      is counted exactly once. Different orders of the same coins
      are not treated as different solutions.

    Notes:
    - Uses a 1D DP array for space optimization.
    - The outer loop iterates over coins, so each combination is built
      by considering coins in a fixed order.
    - Once a larger coin is processed, the algorithm never goes back to
      a smaller coin. Therefore, a combination like {1, 2} is generated,
      but its reordered version {2, 1} is never formed.
    - This guarantees that each unique combination is counted exactly once,
      avoiding duplicate counts due to different coin orders.
    - If the loops are reversed (amount as the outer loop and coins as the
      inner loop), the DP can extend sequences using any coin at every step,
      causing different orders like {1,2} and {2,1} to be counted separately
      as permutations.
    - All computations are performed modulo 1,000,000,007.
*/

class CoinChangeII {

    public static int count(int[] coins, int n, int amount) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};

        System.out.println("Ways : " + count(coins, coins.length, 5)); // 4
        // Combinations:
        // {5}, {2,2,1}, {2,1,1,1}, {1,1,1,1,1}
    }
}