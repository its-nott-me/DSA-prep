/*
    Problem: Frog Jump with K Distance

    Given an array heights[] representing the height of each stair,
    the frog starts from stair 0 and wants to reach stair n-1.

    The frog can jump at most k stairs at a time.

    Cost of jumping from stair i to stair j:
        |heights[i] - heights[j]|

    Find the minimum total cost required to reach the last stair.

    Approach: Dynamic Programming

    dp[i] = minimum cost required to reach stair i

    For every stair i, the frog can jump to:
        i+1, i+2, ..., i+k

    Transition:
        dp[j] = min(
            dp[j],
            dp[i] + |heights[i] - heights[j]|
        )

    Base Case:
        dp[0] = 0

    Answer:
        dp[n-1]

    Time Complexity: O(n * k)
    Space Complexity: O(n)
*/

public class FrogJumpWithKDistance {

    public static int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];

        for(int i = 1; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= i + k && j < n; j++){
                dp[j] = Math.min(
                    dp[j],
                    Math.abs(heights[i] - heights[j]) + dp[i]
                );
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 50, 20};
        int k = 3;

        System.out.println(
            "Minimum Cost: " +
            frogJump(heights, k)
        ); // 30
    }
}
