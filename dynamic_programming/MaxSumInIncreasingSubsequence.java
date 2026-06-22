/*
    Problem: Maximum Sum Increasing Subsequence (MSIS)

    Description:
    Given an array of integers, find the maximum possible sum of a
    strictly increasing subsequence.

    A subsequence is formed by deleting zero or more elements without
    changing the relative order of the remaining elements.

    Approach: Dynamic Programming

    Time Complexity: O(n²)
    Space Complexity: O(n)

    Key Idea:
    - Create a DP array where dp[i] represents the maximum sum of an
      increasing subsequence ending at index i.
    - Initialize dp[i] = arr[i] because every element can form an
      increasing subsequence by itself.
    - For each element arr[i], check all previous elements arr[j]:
        1. If arr[i] > arr[j], arr[i] can extend the subsequence
           ending at j.
        2. Update dp[i] with the maximum sum obtained by extending
           that subsequence.
    - The answer is the maximum value present in the dp array.

    Notes:
    - Unlike Longest Increasing Subsequence (LIS), the goal is to
      maximize the sum rather than the length.
    - dp[i] stores the best sum ending specifically at index i.
    - The final subsequence can end at any index, so we take the
      maximum value from dp.
*/
public class MaxSumInIncreasingSubsequence {

    public static int maxSumIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int res = 0;

        for (int sum : dp) {
            res = Math.max(res, sum);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;

        int result = maxSumIncreasingSubsequence(arr, n);

        System.out.println("Maximum Sum Increasing Subsequence = " + result);
    }
}