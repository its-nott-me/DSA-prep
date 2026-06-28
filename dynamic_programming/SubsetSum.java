/*
    Problem: Subset Sum (Yes/No)

    Goal:
    Check if any subset sums exactly to target.

    DP:
    dp[s] = true if sum 's' is achievable
            using processed elements.

    Idea:
    - Initialize dp[0] = true.
    - For every number, update sums from
      target -> num (backwards).
    - If dp[s - num] is true,
      then dp[s] = true.

    Why backward?
    Prevents using the same element
    multiple times (0/1 Knapsack).

    Note:
    Since the answer is only YES/NO,
    we only store whether a sum is possible,
    not the subset elements themselves.

    Early Exit:
    Return true as soon as dp[target] is true.

    Time : O(n * target)
    Space: O(target)
*/


class SubsetSum {
    public static boolean isSubsetSum(int[] arr, int target) {
        boolean[] dp = new boolean[target+1];

        dp[0] = true;

        for(int num : arr){
            for(int i = target; i >= num; i--){
                if(dp[i-num]) dp[i] = true;
            }
            if(dp[target]) return true;
        }

        return dp[target];
    }


    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};

        int target = 9;

        System.out.println(
            "Subset with sum " + target + " exists: "
            + isSubsetSum(arr, target)
        ); // Output: true
    }
}