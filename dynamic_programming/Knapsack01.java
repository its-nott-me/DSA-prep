/*
    Problem: 0/1 Knapsack

    Given item weights wt[], values val[], and capacity W,
    find the maximum value that can be carried in the knapsack.

    Approach: Dynamic Programming

    dp[i][j] = maximum value using first i items
               with capacity j

    If current item fits:
        take it or leave it

    Transition:
        dp[i][j] = max(
            dp[i-1][j],
            val[i-1] + dp[i-1][j-wt[i-1]]
        )

    Answer: dp[n][W]

    Time Complexity: O(n * W)
    Space Complexity: O(n * W)
*/

class Knapsack01 {
    public static int knapsack01(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n+1][W+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j - wt[i-1]]);
                } else{ 
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int W = 50;

        System.out.println(
            "Maximum Value: " +
            knapsack01(wt, val, wt.length, W)
        ); // 220
    }
}
